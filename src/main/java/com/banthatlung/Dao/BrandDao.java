package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.Brand;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.banthatlung.Dao.db.DBConnect2.getPreparedStatement;

public class BrandDao {


    public BrandDao() {
    }

    public List<Brand> getList() throws SQLException {

        List<Brand> brands = new ArrayList<Brand>();
        String sql = "select * from brands";
        PreparedStatement ps = getPreparedStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs = ps.executeQuery();
        while (rs.next()) {
            brands.add(new Brand(rs.getInt("id"), rs.getString("name"), rs.getDate("Create_At").toString()));
        }
        return brands;

    }

    public Brand getBrand(int id) throws SQLException {
        Brand brand = new Brand();
        PreparedStatement ps = getPreparedStatement("SELECT * from brands where id = ?");
        ;
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs = ps.executeQuery();
        while (rs.next()) {
            brand.setId(rs.getInt("id"));
            brand.setName(rs.getString("name"));
            brand.setCreateAt(String.valueOf(rs.getDate("Create_At")));
        }

        return brand;
    }

    public void add(Brand brand) throws SQLException {
        try {
            PreparedStatement ps = getPreparedStatement("INSERT INTO brands (name, create_At) VALUES (?,?)");
            ps.setString(1, brand.getName());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = brand.getCreateAt();
            java.util.Date utilDate = null;
            utilDate = dateFormat.parse(dateString);
            Date sqlDate = new Date(utilDate.getTime());
            ps.setDate(2, sqlDate);
            ps.executeUpdate();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(Brand brand) throws SQLException {
        try {
            PreparedStatement ps = getPreparedStatement("UPDATE brands SET name = ?, create_At = ? WHERE id = ?");
            ps.setString(1, brand.getName());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = brand.getCreateAt();
            java.util.Date utilDate = dateFormat.parse(dateString);
            Date sqlDate = new Date(utilDate.getTime());
            ps.setDate(2, sqlDate);
            ps.setInt(3, brand.getId());
            ps.executeUpdate();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) throws SQLException {
        PreparedStatement ps = getPreparedStatement("DELETE FROM brands WHERE id = ?");

        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {

        BrandDao dao = new BrandDao();
        for (Brand brand : dao.getList()) {
            System.out.println(brand);
        }
    }
}
