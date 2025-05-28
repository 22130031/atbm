package com.banthatlung.Controller.admin;


import com.banthatlung.Dao.CategoryDao;
import com.banthatlung.Dao.model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/admin_Categories/edit"})
public class Category_Edit_Controller extends HttpServlet {
    CategoryDao categoryDao = new CategoryDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Category category = categoryDao.getCategory(id);
            req.setAttribute("category", category);
            req.getRequestDispatcher("/html_admin/admin_Categories_edit.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            categoryDao.update(new Category(id, name, description));
            resp.sendRedirect(req.getContextPath() + "/admin_Categories");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
