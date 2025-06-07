package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.OrderDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDao {
    public List<OrderDetail> getDetailsByUser(String userId) throws SQLException {
        List<OrderDetail> list = new ArrayList<>();
        String sql = """
            SELECT od.*, p.name AS product_name
            FROM order_details od
            JOIN products p ON od.product_id = p.id
            WHERE od.user_id = ?
            ORDER BY od.order_id DESC
        """;

        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setString(1, userId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new OrderDetail(
                    rs.getInt("id"),
                    rs.getString("user_id"),
                    rs.getInt("order_id"),
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getInt("quantity"),
                    rs.getInt("price")
            ));
        }
        return list;
    }

    public List<OrderDetail> getDetailsByOrderId(int orderId) throws SQLException {
        List<OrderDetail> list = new ArrayList<>();
        String sql = """
            SELECT od.*, p.name AS product_name
            FROM order_details od
            JOIN products p ON od.product_id = p.id
            WHERE od.order_id = ?
        """;
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setInt(1, orderId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new OrderDetail(
                    rs.getInt("id"),
                    rs.getString("user_id"),
                    rs.getInt("order_id"),
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getInt("quantity"),
                    rs.getInt("price")
            ));
        }
        return list;
    }

    public List<OrderDetail> getList(int id) throws SQLException {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "select * from order_details where order_id=?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new OrderDetail(
                    rs.getInt("id"),
                    rs.getString("user_id"),
                    rs.getInt("order_id"),
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getInt("quantity"),
                    rs.getInt("price")
            ));
        }
        return list;
    }

    public boolean addOrderDetail(OrderDetail orderDetail) {
        String sql = "INSERT INTO order_details (id, order_id, product_id, quantity, price, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
        boolean isAdded = false;

        try {
            PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
            ps.setInt(1, orderDetail.getId());
            ps.setInt(2, orderDetail.getOrder_id());
            ps.setInt(3, orderDetail.getProduct_id());
            ps.setInt(4, orderDetail.getQuantity());
            ps.setInt(5, orderDetail.getPrice());
            int rowsInserted = ps.executeUpdate();
            isAdded = rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM order_details WHERE id = ?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}