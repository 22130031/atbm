package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.Order;
import com.banthatlung.Dao.model.OrderDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDao {


    public List<OrderDetail> getList(int id) throws SQLException {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "select * from order_details where order_id=?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new OrderDetail(rs.getInt("order_id"), rs.getInt("product_id"), rs.getInt("quantity"), rs.getInt("price")));
        }
        return list;
    }

    public boolean addOrderDetail(OrderDetail orderDetail) {
        String sql = "INSERT INTO order_details (id, order_id, product_id, quantity, price, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
        boolean isAdded = false;

        try {
            PreparedStatement ps = DBConnect2.getPreparedStatement(sql);

            // Set parameters for the prepared statement
            ps.setInt(1, orderDetail.getId());
            ps.setInt(2, orderDetail.getOrder_id());
            ps.setInt(3, orderDetail.getProduct_id());
            ps.setInt(4, orderDetail.getQuantity());
            ps.setInt(5, orderDetail.getPrice());

            // Execute update and check if the record was inserted
            int rowsInserted = ps.executeUpdate();
            isAdded = rowsInserted > 0;

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    public void updateOrder(Order order) {
        try {
            String sql = "UPDATE orders SET user_id = ?, status = ?, total_amount = ?, update_date = CURRENT_TIMESTAMP WHERE id = ?";
            PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
            ps.setInt(1, order.getId());
            ps.setInt(2, order.getStatus());
            ps.setInt(3, order.getTotal_amount());
            ps.setInt(4, order.getId());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Order updated successfully!");
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) throws SQLException {
        PreparedStatement ps = DBConnect2.getPreparedStatement("DELETE FROM Orders WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {

        OrderDetailDao dao = new OrderDetailDao();
        OrderDetail o = new OrderDetail(1, 22, 1, 21);
        dao.getList(42);
    }
}
