package com.banthatlung.Dao;

import com.banthatlung.Dao.model.Order;
import com.banthatlung.Dao.db.DBConnect2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public List<Order> getOrdersByUser(String userId) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE user_id = ?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setString(1, userId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Order order = new Order(
                    rs.getInt("id"),
                    rs.getString("user_id"),
                    rs.getInt("order_code"),
                    rs.getInt("total_price"),
                    rs.getString("order_date"),
                    rs.getInt("status")
            );
            orders.add(order);
        }
        return orders;
    }

    public int addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO orders (user_id, order_code, total_price, status) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, order.getUserId());
        ps.setInt(2, order.getOrderCode());
        ps.setInt(3, order.getTotalPrice());
        ps.setInt(4, order.getStatus());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) return rs.getInt(1);
        return -1;
    }

    public void updateOrder(Order order) throws SQLException {
        String sql = "UPDATE orders SET user_id = ?, order_code = ?, total_price = ?, status = ? WHERE id = ?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setString(1, order.getUserId());
        ps.setInt(2, order.getOrderCode());
        ps.setInt(3, order.getTotalPrice());
        ps.setInt(4, order.getStatus());
        ps.setInt(5, order.getId());
        ps.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM orders WHERE id = ?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    public Order getOrderById(int id) throws SQLException {
        String sql = "SELECT * FROM orders WHERE id = ?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Order(
                    rs.getInt("id"),
                    rs.getString("user_id"),
                    rs.getInt("order_code"),
                    rs.getInt("total_price"),
                    rs.getString("order_date"),
                    rs.getInt("status")
            );
        }
        return null;
    }

}
