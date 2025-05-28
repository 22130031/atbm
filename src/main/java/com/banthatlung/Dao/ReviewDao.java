package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.Review;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReviewDao {
    public void addReview(Review review) {
        String query = "INSERT INTO reviews (review_id, product_id, user_id, rating, url, review_text, review_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (
             PreparedStatement stmt = DBConnect2.getPreparedStatement(query)) {
            stmt.setString(1, "r"+(getTotalReviews()+1));
            stmt.setInt(2, review.getProductId());
            stmt.setString(3, review.getUserId());
            stmt.setInt(4, review.getRating());
            stmt.setString(5, review.getUrl());
            stmt.setString(6, review.getReviewText());
            stmt.setString(7, review.getReviewDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Review> getReviewsByProductId(String pid){
        int id = Integer.parseInt(pid);
    ArrayList<Review> reviews = new ArrayList<Review>();
    String sql = "select * from reviews where product_id = ?";
    ResultSet rs=null;
    try {
        PreparedStatement  pstmt = DBConnect2.getPreparedStatement(sql);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            Review r =new Review(rs.getString(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7));
            r.setUsername(getUsernameById(rs.getString(3)));
            r.setUimg(getUserIMGById(rs.getString(3)));
            reviews.add(r);
            }
        return reviews;
        }
    catch (SQLException e) {
        return reviews;
    }
    }
    public List<Review> getReviewsByRating(String pid, String rating){
        int id = Integer.parseInt(pid);
        int r = Integer.parseInt(rating);
        ArrayList<Review> reviews = new ArrayList<Review>();
        String sql = "select * from reviews where product_id = ? and rating = ?";
        ResultSet rs=null;
        try {
            PreparedStatement  pstmt = DBConnect2.getPreparedStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setInt(2, r);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                reviews.add(new Review(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            return reviews;
        }
        catch (SQLException e) {
            return reviews;
        }
    }
    public List<Review> getReviewsByImg(String pid){
        int id = Integer.parseInt(pid);
        ArrayList<Review> reviews = new ArrayList<Review>();
        String sql = "select * from reviews where url IS NOT NULL and product_id = ?";
        ResultSet rs=null;
        try {
            PreparedStatement  pstmt = DBConnect2.getPreparedStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                reviews.add(new Review(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            return reviews;
        }
        catch (SQLException e) {
            return reviews;
        }
    }
    public List<Review> getReviewsByComment(String pid){
        int id = Integer.parseInt(pid);
        ArrayList<Review> reviews = new ArrayList<Review>();
        String sql = "select * from reviews where review_text IS NOT NULL and product_id = ?";
        ResultSet rs=null;
        try {
            PreparedStatement  pstmt = DBConnect2.getPreparedStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                reviews.add(new Review(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            return reviews;
        }
        catch (SQLException e) {
            return reviews;
        }
    }
    public int getTotalReviews() {
        String query = "SELECT COUNT(*) AS total FROM reviews";
        ResultSet rs = null;
        try (
             PreparedStatement stmt = DBConnect2.getPreparedStatement(query)) {
             rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public String getUsernameById(String id) {
        String query = "select * from users where user_id = ?";
        ResultSet rs = null;
        try {
            PreparedStatement  pstmt = DBConnect2.getPreparedStatement(query);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) return rs.getString("username");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public String getUserIMGById(String id) {
        String query = "select * from users where user_id = ?";
        ResultSet rs = null;
        try {
            PreparedStatement  pstmt = DBConnect2.getPreparedStatement(query);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) return rs.getString("avatar_url");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
