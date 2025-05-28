package com.banthatlung.Controller;

import com.banthatlung.Dao.model.Product;
import com.banthatlung.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet(name = "Search",value = "/search")
public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String search = req.getParameter("search");
        ProductService service = new ProductService();
        List<Product> products = service.search(search);
        req.setAttribute("productList", products);
        req.getRequestDispatcher("/View/home.jsp").forward(req, resp);
    }
}
