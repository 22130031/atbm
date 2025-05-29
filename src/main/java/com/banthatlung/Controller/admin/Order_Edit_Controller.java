package com.banthatlung.Controller.admin;

import com.banthatlung.Dao.MaterialDao;
import com.banthatlung.Dao.OrderDao;
import com.banthatlung.Dao.model.Material;
import com.banthatlung.Dao.model.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/admin_Order/edit"})
public class Order_Edit_Controller extends HttpServlet {
    OrderDao orderDao = new OrderDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Order order = orderDao.getOrder(id);
            req.setAttribute("order", order);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("/html_admin/admin_Orders_edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String status = req.getParameter("status");
        int total = Integer.parseInt(req.getParameter("total"));
        Order order = new Order(id, name, phone, address, status, total);
        System.out.println(order.getId());
        orderDao.updateOrder(order);

        resp.sendRedirect(req.getContextPath() + "/admin_Orders");
    }
}
