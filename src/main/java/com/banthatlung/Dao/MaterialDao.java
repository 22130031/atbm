package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialDao {


    public MaterialDao() {
    }

    public Material getMaterial(int id) throws SQLException {
        Material material = new Material();
        PreparedStatement ps = DBConnect2.getPreparedStatement("SELECT * from materials where id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs = ps.executeQuery();
        while (rs.next()) {
            material.setId(rs.getInt("id"));
            material.setName(rs.getString("name"));
        }

        return material;
    }

    public List<Material> getList() throws SQLException {
        List<Material> materialList = new ArrayList<Material>();
        PreparedStatement ps = DBConnect2.getPreparedStatement("SELECT * from materials");
        ResultSet rs = ps.executeQuery();
        rs = ps.executeQuery();
        while (rs.next()) {
            materialList.add(new Material(rs.getInt("id"), rs.getString("name")));
        }
        return materialList;
    }

    public void add(Material material) throws SQLException {

        String sql = "INSERT INTO materials (name) VALUES (?)";
        // Using try-with-resources to ensure resources are closed automatically
        try (PreparedStatement ps = DBConnect2.getPreparedStatement(sql)) {

            // Set the name parameter
            ps.setString(1, material.getName());
            // Execute the update
            ps.executeUpdate();
            System.out.println("Material added successfully.");
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
            System.err.println("Error while adding material: " + e.getMessage());
        }
    }

    public void update(Material material) throws SQLException {
        String sql = "UPDATE materials SET name = ? WHERE id = ?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setString(1, material.getName());
        ps.setInt(2, material.getId());
        ps.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM materials WHERE id = ?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {
        Material dao = new Material("sacsabre");
        System.out.println(dao.getName());
    }
}
