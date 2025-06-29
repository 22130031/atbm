package com.banthatlung.Controller.admin;


import com.banthatlung.Dao.KeyDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/admin_Keys")
public class AdminKeyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("create".equals(action)) {
            int keysize = Integer.parseInt(req.getParameter("keysize"));
            KeyDAO.addKey(keysize);
        } else if ("revoke".equals(action)) {
            int keyId = Integer.parseInt(req.getParameter("id"));
            KeyDAO.revokeKey(keyId);
        }

        req.setAttribute("keys", KeyDAO.getAllKeys());
        req.getRequestDispatcher("/html_admin/admin_keys.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("keys", KeyDAO.getAllKeys());
        req.getRequestDispatcher("/html_admin/admin_keys.jsp").forward(req, resp);
    }
}
