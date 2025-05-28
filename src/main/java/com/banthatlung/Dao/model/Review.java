package com.banthatlung.Dao.model;

import java.io.Serializable;

public class Review implements Serializable {
    private String reviewId;
    private int productId;
    private String userId;
    private int rating;
    private String url;
    private String reviewText;
    private String reviewDate;
    private String username;
    private String uimg;

    public String getUimg() {
        return uimg;
    }

    public void setUimg(String uimg) {
        this.uimg = uimg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Constructors
    public Review() {}

    public Review(String reviewId, int productId, String userId, int rating, String url, String reviewText, String reviewDate) {
        this.reviewId = reviewId;
        this.productId = productId;
        this.userId = userId;
        this.rating = rating;
        this.url = url;
        this.reviewText = reviewText;
        this.reviewDate = reviewDate;
    }

    // Getters and Setters
    public String getReviewId() { return reviewId; }
    public void setReviewId(String reviewId) { this.reviewId = reviewId; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getReviewText() { return reviewText; }
    public void setReviewText(String reviewText) { this.reviewText = reviewText; }

    public String getReviewDate() { return reviewDate; }
    public void setReviewDate(String reviewDate) { this.reviewDate = reviewDate; }
}
