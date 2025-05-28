package com.banthatlung.Controller.admin;


import com.banthatlung.Dao.BrandDao;
import com.banthatlung.Dao.model.Brand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/admin_Brands/edit"})
public class Brands_Edit_Controller extends HttpServlet {
    BrandDao brandDao = new BrandDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Brand brand = brandDao.getBrand(id);
            req.setAttribute("brand", brand);
            req.getRequestDispatcher("/html_admin/admin_Brands_edit.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String date = req.getParameter("created_At");
            brandDao.update(new Brand(id, name,date));
            resp.sendRedirect(req.getContextPath() + "/admin_Brands");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
