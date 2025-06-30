package com.banthatlung.Controller;



import com.banthatlung.Dao.KeyDAO;
import com.banthatlung.Dao.model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/generate-user-key")
public class KeyController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String userId = user.getId();
        String email = user.getEmail();

        if (KeyDAO.hasKey(userId)) {
            request.setAttribute("message", "Người dùng đã có khóa!");
        } else {
            boolean success = KeyDAO.generateKeyForUser(userId, email);
            if (success) {
                request.setAttribute("message", "Tạo khóa thành công!");
            } else {
                request.setAttribute("message", "Lỗi khi tạo khóa!");
            }
        }

        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}

