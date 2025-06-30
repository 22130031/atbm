package com.banthatlung.Controller;

import com.banthatlung.Dao.KeyDAO;
import com.banthatlung.Dao.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/report-lost-key")
public class LostKeyController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("auth");

        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        boolean result = KeyDAO.reportLostKey(user.getId());
        if (result) {
            req.getSession().setAttribute("message", "Đã báo mất khóa thành công.");
        } else {
            req.getSession().setAttribute("error", "Không thể báo mất khóa.");
        }
        resp.sendRedirect(req.getContextPath() + "/profile");
    }
}
