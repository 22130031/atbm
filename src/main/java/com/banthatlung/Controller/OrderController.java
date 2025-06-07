package com.banthatlung.Controller;

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
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/orders"})
public class OrderController extends HttpServlet {
    private final OrderDao orderDao = new OrderDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String filter = req.getParameter("filter");
        String search = req.getParameter("search");

        try {
            // Lấy danh sách hóa đơn với bộ lọc và tìm kiếm
            List<Order> orderList = orderDao.getAllOrders();
            if (filter != null && !filter.isEmpty() && !"all".equals(filter)) {
                orderList = orderList.stream()
                        .filter(order -> "signed".equals(filter) ? order.isSigned() : !order.isSigned())
                        .collect(Collectors.toList());
            }
            if (search != null && !search.isEmpty()) {
                String finalSearch = search;
                orderList = orderList.stream()
                        .filter(order -> String.valueOf(order.getOrderCode()).contains(finalSearch))
                        .collect(Collectors.toList());
            }
            req.setAttribute("OrderList", orderList);
            req.getRequestDispatcher("/View/orders.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Không thể xử lý yêu cầu.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if ("sign".equals(action)) {
                // Ký hóa đơn
                String[] ids = req.getParameter("ids").split(",");
                for (String id : ids) {
                    orderDao.updateSignedStatus(Integer.parseInt(id), true);
                }
                resp.sendRedirect("orders");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Không thể xử lý yêu cầu.");
        }
    }
}