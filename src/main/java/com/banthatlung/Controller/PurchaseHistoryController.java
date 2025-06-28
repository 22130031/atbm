package com.banthatlung.Controller;

import com.banthatlung.Dao.OrderDetailDao;
import com.banthatlung.Dao.model.OrderDetail;
import com.banthatlung.Dao.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
@WebServlet(name = "PurchaseHistoryController", value = "/purchase-history")
public class PurchaseHistoryController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("auth");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/View/Login.jsp");
            return;
        }

        try {
            OrderDetailDao dao = new OrderDetailDao();
            List<OrderDetail> history = dao.getDetailsByUser(user.getId());

            request.setAttribute("historyList", history);
            request.getRequestDispatcher("/View/purchase-history.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

