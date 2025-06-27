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

@WebServlet(urlPatterns = {"/admin_Order/edit"})
public class Order_Edit_Controller extends HttpServlet {
    private final OrderDao orderDao = new OrderDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Order order = orderDao.getOrderById(id);
            req.setAttribute("order", order);
            req.getRequestDispatcher("/html_admin/admin_Orders_edit.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/admin_Orders");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String userId = req.getParameter("userId");
            int orderCode = Integer.parseInt(req.getParameter("orderCode"));
            int totalPrice = Integer.parseInt(req.getParameter("totalPrice"));
            int status = Integer.parseInt(req.getParameter("status"));

            Order existingOrder = orderDao.getOrderById(id);
            String orderDate = existingOrder != null ? existingOrder.getOrderDate() : null;

            Order updatedOrder = new Order(id, userId, orderCode, totalPrice, orderDate, status);
            orderDao.updateOrder(updatedOrder);

            resp.sendRedirect(req.getContextPath() + "/admin_Orders");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Cập nhật thất bại.");
        }
    }
}
