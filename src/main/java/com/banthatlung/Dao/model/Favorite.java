package com.banthatlung.Dao.model;

import java.io.Serializable;

public class Favorite implements Serializable {
    private int id;
    private String userId;
    private int productId;
    private String productName;
    private String imageUrl;

    public Favorite() {
    }

    public Favorite(int id, String userId, int productId, String productName, String imageUrl) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.productName = productName;
        this.imageUrl = imageUrl;
    }

    public Favorite(String userId, int productId, String productName, String imageUrl) {
        this.userId = userId;
        this.productId = productId;
        this.productName = productName;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}