package com.banthatlung.Controller.admin;


import com.banthatlung.Dao.OrderDao;
import com.banthatlung.Dao.model.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin_Orders"})
public class OrderController extends HttpServlet {
    OrderDao OrderDao = new OrderDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        List<Order> OrderList = null;
        try {
            OrderList = OrderDao.getList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("OrderList", OrderList);
        req.getRequestDispatcher("/html_admin/admin_Orders.jsp").forward(req, resp);
    }
}
