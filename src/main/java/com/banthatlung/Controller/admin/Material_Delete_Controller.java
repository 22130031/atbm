package com.banthatlung.Controller.admin;


import com.banthatlung.Dao.BrandDao;
import com.banthatlung.Dao.MaterialDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/admin_Materials/delete"})
public class Material_Delete_Controller extends HttpServlet {
    MaterialDao brandDao = new MaterialDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter("id");
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            brandDao.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/admin_Materials");
    }


}
