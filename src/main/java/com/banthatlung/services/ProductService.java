package com.banthatlung.services;

import com.banthatlung.Dao.ProductDao;
import com.banthatlung.Dao.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    static ProductDao productDao = new ProductDao();

    public static void Update(Product product) throws SQLException {
        productDao.update(product);
    }
    public static Product getById(int id) {
        return productDao.getById(id);
    }
    public static  void add(Product product) {
        productDao.addProduct(product);
    }
    public static void AddProduct(Product product) {
        productDao.addProduct(product);
    }
    public static void UpdateProduct(Product product) {
        productDao.update(product);
    }

    public static void DeleteProduct(int id) throws SQLException {
        productDao.delete(id);
    }

    public List<Product> getAll() {
        return productDao.getAll();
    }

    public List<Product> getAll(int page, int pageSize) {
        return productDao.getAll( page, pageSize);
    }

    public Product getDetail(String in) {
        try {
            int id = Integer.parseInt(in);
            return productDao.getById(id);
        } catch (NumberFormatException e) {
            return null;
        }

    }

    public List<Product> search(String in) {
        return productDao.search(in);
    }

    public int getTotalProductCount() {
        return productDao.getTotalProductCount();
    }
}
