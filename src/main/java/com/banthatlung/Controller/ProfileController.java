package com.banthatlung.Controller;

import com.banthatlung.Dao.model.User;
import com.banthatlung.services.ProfileService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "ProfileController",value = "/profile")
public class ProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/View/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String dob = req.getParameter("dob");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("auth");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/View/login.jsp");
            return;
        }

        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setBirthday(Date.valueOf(dob));

        ProfileService profileService = new ProfileService();
        boolean updated;
        try {
            updated = profileService.updateUserProfile(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (updated) {
            session.setAttribute("auth", user);

            System.out.println(name+email+phone+dob+user.getId());
            resp.sendRedirect(req.getContextPath() + "/View/profile.jsp");
        } else {
            req.setAttribute("error", "Cập nhật không thành công!");
            req.getRequestDispatcher("/View/profile.jsp").forward(req, resp);
        }
    }
}
