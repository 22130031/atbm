package com.banthatlung.Controller.admin;


import com.banthatlung.Dao.BrandDao;
import com.banthatlung.Dao.model.Brand;
import com.banthatlung.Dao.model.Product;
import com.banthatlung.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin_Products"})
public class ProductController extends HttpServlet {
    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        List<Product> productList= null;
        productList = productService.getAll();
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/html_admin/admin_Products.jsp").forward(req, resp);
    }

}
