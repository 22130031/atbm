package com.banthatlung.Controller.admin;
import com.banthatlung.Dao.BrandDao;
import com.banthatlung.Dao.CategoryDao;
import com.banthatlung.Dao.MaterialDao;
import com.banthatlung.Dao.model.Brand;
import com.banthatlung.Dao.model.Category;
import com.banthatlung.Dao.model.Material;
import com.banthatlung.Dao.model.Product;
import com.banthatlung.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin_Products/edit"})
public class Product_Edit_Controller extends HttpServlet {
    MaterialDao materialDao = new MaterialDao();
    ProductService productService = new ProductService();
    CategoryDao categoryDao = new CategoryDao();
    BrandDao brandDao = new BrandDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        List<Brand> brandList = null;
        List<Category> categoryList = null;
        List<Material> materialList = null;
        Product product = ProductService.getById(id);
        req.setAttribute("product", product);
        try {
            brandList = brandDao.getList();
            categoryList = categoryDao.getAllCategory();
            materialList = materialDao.getList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("categoryList", categoryList);
        req.setAttribute("brandList", brandList);
        req.setAttribute("materialList", materialList);
        req.getRequestDispatcher("/html_admin/admin_Products_edit.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int price = Integer.parseInt(req.getParameter("price"));
        try {
            Category category = categoryDao.getCategory(Integer.parseInt(req.getParameter("category")));
            Brand brand = brandDao.getBrand(Integer.parseInt(req.getParameter("brand")));
            Material material = new Material();
            material.setId(2);

            //Material material = new MaterialDao().getMaterial(Integer.parseInt(req.getParameter("material")));
            String image = req.getParameter("image");
            int status = Integer.parseInt(req.getParameter("status"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            productService.Update(new Product(name,price,description,status,quantity,image,category,brand,material));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/admin_Products");

    }
}
