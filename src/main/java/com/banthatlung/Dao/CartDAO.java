package com.banthatlung.Dao;

import com.banthatlung.Dao.model.CartItem;

import java.sql.*;
import java.util.*;

public class CartDAO {
    private Connection conn;

    public CartDAO(Connection conn) {
        this.conn = conn;
    }

    // Lấy danh sách giỏ hàng theo user
    public List<CartItem> getCartByUser(int userId) {
        List<CartItem> cart = new ArrayList<>();
        String sql = "SELECT * FROM cart_items WHERE user_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CartItem item = new CartItem();
                item.setId(rs.getInt("id"));
                item.setUserId(rs.getInt("user_id"));
                item.setProductId(rs.getInt("product_id"));
                item.setQuantity(rs.getInt("quantity"));
                // Optional: lấy thêm thông tin sản phẩm nếu cần
                cart.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    // Thêm sản phẩm vào giỏ hàng
    public void addToCart(int userId, int productId, int quantity) {
        String sql = "INSERT INTO cart_items (user_id, product_id, quantity) " +
                "VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE quantity = quantity + ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, productId);
            stmt.setInt(3, quantity);
            stmt.setInt(4, quantity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật số lượng sản phẩm
    public void updateQuantity(int userId, int productId, int quantity) {
        String sql = "UPDATE cart_items SET quantity = ? WHERE user_id = ? AND product_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, quantity);
            stmt.setInt(2, userId);
            stmt.setInt(3, productId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa sản phẩm khỏi giỏ
    public void removeItem(int userId, int productId) {
        String sql = "DELETE FROM cart_items WHERE user_id = ? AND product_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, productId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa toàn bộ giỏ hàng theo user (dùng khi checkout)
    public void clearCart(int userId) {
        String sql = "DELETE FROM cart_items WHERE user_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Merge cart từ session vào database
    public void mergeSessionCart(int userId, List<CartItem> sessionCart) {
        for (CartItem item : sessionCart) {
            addToCart(userId, item.getProductId(), item.getQuantity());
        }
    }


}

