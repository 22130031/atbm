package com.banthatlung.Controller;

import com.banthatlung.Dao.OrderDao;
import com.banthatlung.Dao.OrderDetailDao;
import com.banthatlung.Dao.model.*;
import com.banthatlung.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;


@WebServlet(urlPatterns = {"/CheckOut"})
public class CheckOutController extends HttpServlet {
    OrderDao orderDao = new OrderDao();
    OrderDetailDao orderDetailDao = new OrderDetailDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);

        ProductCart productCart;
        if(session==null){
            System.out.println("session is null");
        }
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        try {
            req.setAttribute("cart", cart);
            req.getRequestDispatcher("/View/CheckOut.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int orderCode = Math.abs(UUID.randomUUID().toString().hashCode());
        User user = (User) session.getAttribute("auth");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/View/login.jsp");
            return;
        }
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        int total =0;
        for(Map.Entry<Integer, ProductCart> entry : cart.entrySet()){
            total += entry.getValue().getProduct().getPrice();
        }
        Order order = new Order( user.getId(),orderCode,total);
        int id = 0;
        try {
            id = orderDao.addOrder(order);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for(Map.Entry<Integer, ProductCart> entry : cart.entrySet()){
            OrderDetail orderDetail = new OrderDetail(id, user.getId(), entry.getValue().getProduct().getId(),entry.getValue().getQuantity(), (int) (entry.getValue().getProduct().getPrice()*entry.getValue().getQuantity()));
            orderDetailDao.addOrderDetail(orderDetail);
        }
        session.setAttribute("cart", null);
        resp.sendRedirect(req.getContextPath()+"/View/checkOutDone.jsp");
    }
}