package com.banthatlung.Controller.admin;


import com.banthatlung.Dao.BrandDao;
import com.banthatlung.Dao.MaterialDao;
import com.banthatlung.Dao.model.Brand;
import com.banthatlung.Dao.model.Material;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin_Brands"})
public class BrandController extends HttpServlet {
    BrandDao brandDao = new BrandDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        List<Brand> brandList = null;
        try {
            brandList = brandDao.getList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("brandList", brandList);
        req.getRequestDispatcher("/html_admin/admin_Brands.jsp").forward(req, resp);
    }
}
