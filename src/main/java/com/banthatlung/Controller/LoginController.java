package com.banthatlung.Controller;

import com.banthatlung.Dao.model.User;
import com.banthatlung.services.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("uname");
        String password = req.getParameter("pass");

        String hashpass = PasswordUtils.encryptPassword(password);
        AuthService authService = new AuthService();
        User user = authService.checkLogin(username, hashpass);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("auth", user);

            Cookie userCookie = new Cookie("userId", String.valueOf(user.getId()));
            userCookie.setMaxAge(60 * 60 * 24 * 7);
            userCookie.setPath(req.getContextPath());
            resp.addCookie(userCookie);

            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("/View/Login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/View/Login.jsp").forward(req, resp);
    }
}

