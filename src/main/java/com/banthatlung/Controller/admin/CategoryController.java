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
import java.util.List;

@WebServlet(urlPatterns = {"/admin_Categories"})
public class CategoryController extends HttpServlet {
    CategoryDao categoryDao = new CategoryDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        List<Category> categoryList = null;
        try {
            categoryList = categoryDao.getAllCategory() ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("/html_admin/admin_Categories.jsp").forward(req, resp);
    }
}
