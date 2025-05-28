package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.Favorite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDao {

    // Ánh xạ ResultSet thành đối tượng Favorite
    private Favorite mapFavorite(ResultSet rs) throws SQLException {
        return new Favorite(
                rs.getInt("id"),
                rs.getString("user_id"),
                rs.getInt("product_id"),
                rs.getString("product_name"),
                rs.getString("image_url")
        );
    }

    // Lấy tất cả sản phẩm yêu thích theo user_id
    public List<Favorite> getAllByUserId(String userId) {
        List<Favorite> result = new ArrayList<>();
        String sql = """
                SELECT id, user_id, product_id, product_name, image_url
                FROM favorites
                WHERE user_id = ?
                """;
        try (PreparedStatement ps = DBConnect2.getPreparedStatement(sql)) {
            ps.setString(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(mapFavorite(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Thêm sản phẩm yêu thích
    public boolean add(Favorite favorite) {
        String sql = """
                INSERT INTO favorites (user_id, product_id, product_name, image_url)
                VALUES (?, ?, ?, ?)
                """;
        try (PreparedStatement ps = DBConnect2.getPreparedStatement(sql)) {
            ps.setString(1, favorite.getUserId());
            ps.setInt(2, favorite.getProductId());
            ps.setString(3, favorite.getProductName());
            ps.setString(4, favorite.getImageUrl());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa sản phẩm yêu thích
    public boolean delete(String userId, int productId) {
        String sql = """
                DELETE FROM favorites
                WHERE user_id = ? AND product_id = ?
                """;
        try (PreparedStatement ps = DBConnect2.getPreparedStatement(sql)) {
            ps.setString(1, userId);
            ps.setInt(2, productId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Kiểm tra xem sản phẩm đã được yêu thích bởi user chưa
    public boolean isFavorite(String userId, int productId) {
        String sql = """
                SELECT COUNT(*) FROM favorites
                WHERE user_id = ? AND product_id = ?
                """;
        try (PreparedStatement ps = DBConnect2.getPreparedStatement(sql)) {
            ps.setString(1, userId);
            ps.setInt(2, productId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy sản phẩm yêu thích theo ID
    public Favorite getById(int id) {
        String sql = """
                SELECT id, user_id, product_id, product_name, image_url
                FROM favorites
                WHERE id = ?
                """;
        try (PreparedStatement ps = DBConnect2.getPreparedStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapFavorite(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}