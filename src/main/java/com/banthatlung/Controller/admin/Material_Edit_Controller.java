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

@WebServlet(urlPatterns = {"/admin_Material/edit"})
public class Material_Edit_Controller extends HttpServlet {
    MaterialDao materialDao = new MaterialDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Material material = materialDao.getMaterial(id);
            req.setAttribute("material", material);
            req.getRequestDispatcher("/html_admin/admin_Materials_edit.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            materialDao.update(new Material(id, name));
            resp.sendRedirect(req.getContextPath() + "/admin_Materials");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
