package com.banthatlung.Controller.admin;


import com.banthatlung.Dao.CategoryDao;
import com.banthatlung.Dao.model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/admin_Categories/add"})
public class Category_Add_Controller extends HttpServlet {
    CategoryDao categoryDao = new CategoryDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/html_admin/admin_Categories_add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        try {
            categoryDao.add(new Category(name,description));
            resp.sendRedirect(req.getContextPath()+ "/admin_Categories");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
