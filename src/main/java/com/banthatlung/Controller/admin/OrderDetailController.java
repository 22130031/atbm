package com.banthatlung.Controller.admin;


import com.banthatlung.Dao.OrderDao;
import com.banthatlung.Dao.OrderDetailDao;
import com.banthatlung.Dao.model.Order;
import com.banthatlung.Dao.model.OrderDetail;
import com.banthatlung.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin_OrderDetails"})
public class OrderDetailController extends HttpServlet {
   OrderDetailDao orderDetailDao = new OrderDetailDao();
   ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        List<OrderDetail> OrderDetailList = null;
        try {
            OrderDetailList = orderDetailDao.getList(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("OrderDetailList", OrderDetailList);
        req.getRequestDispatcher("/html_admin/admin_OrderDetails.jsp").forward(req, resp);
    }
}
