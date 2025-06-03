package com.banthatlung.Controller;

import com.banthatlung.Dao.PurchaseHistoryDao;
import com.banthatlung.Dao.model.PurchaseHistory;
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
            response.sendRedirect(request.getContextPath() + "/View/login.jsp");
            return;
        }

        String userId = user.getId();
        String filter = request.getParameter("filter");
        if (filter == null) filter = "all";

        try {
            PurchaseHistoryDao dao = new PurchaseHistoryDao();
            List<PurchaseHistory> all = dao.getHistoryByUser(userId);

            List<PurchaseHistory> filtered = switch (filter) {
                case "signed" -> all.stream().filter(PurchaseHistory::isSigned).collect(Collectors.toList());
                case "unsigned" -> all.stream().filter(ph -> !ph.isSigned()).collect(Collectors.toList());
                default -> all;
            };

            request.setAttribute("filter", filter);
            request.setAttribute("historyList", filtered);
            request.getRequestDispatcher("/View/purchase-history.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

