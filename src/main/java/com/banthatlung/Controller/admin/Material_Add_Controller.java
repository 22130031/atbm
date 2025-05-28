package com.banthatlung.Controller.admin;
import com.banthatlung.Dao.MaterialDao;
import com.banthatlung.Dao.model.Material;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/admin_Materials/add"})
public class Material_Add_Controller extends HttpServlet {
    MaterialDao materialDao = new MaterialDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/html_admin/admin_Materials_add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        try {
            materialDao.add(new Material(name));
            resp.sendRedirect(req.getContextPath() + "/admin_Materials");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
