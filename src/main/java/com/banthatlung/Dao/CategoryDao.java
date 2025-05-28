package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.banthatlung.Dao.db.DBConnect2.getPreparedStatement;

public class CategoryDao {

    public CategoryDao() {
    }

    public Category getCategory(int id) throws SQLException {
        PreparedStatement ps = DBConnect2.getPreparedStatement("SELECT * from categories where id = ?");
        Category category = new Category();
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs = ps.executeQuery();
        while (rs.next()) {
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            category.setDescription(rs.getString("description"));
        }

        return category;
    }

    public List<Category> getAllCategory() throws SQLException {
        List<Category> categories = new ArrayList<Category>();
        PreparedStatement ps = getPreparedStatement("Select * from categories");
        ResultSet rs = ps.executeQuery();
        rs = ps.executeQuery();
        while (rs.next()) {
            categories.add(new Category(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
        }
        return categories;
    }

    public void add(Category category) throws SQLException {
        PreparedStatement ps = DBConnect2.getPreparedStatement("INSERT INTO categories (name, description) VALUES (?,?)");


        ps.setString(1, category.getName());
        ps.setString(2, category.getDescription());
        ps.executeUpdate();
    }

    public void update(Category category) throws SQLException {
        PreparedStatement ps = DBConnect2.getPreparedStatement("UPDATE categories SET name = ?, Description = ? WHERE id = ?");

        ps.setString(1, category.getName());
        ps.setString(2, category.getDescription());
        ps.setInt(3, category.getId());
        ps.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        PreparedStatement ps = DBConnect2.getPreparedStatement("DELETE FROM categories WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {
        CategoryDao categoryDao = new CategoryDao();
        Category category = new Category("zzdsadazzz", "zzcấcz");
        category.setId(1);
        categoryDao.update(category);
    }
}
