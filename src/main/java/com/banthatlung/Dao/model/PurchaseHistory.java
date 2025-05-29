package com.banthatlung.Dao.model;

public class PurchaseHistory {
    private int id;
    private String userId;      // CHỈNH: userId là String
    private int orderId;
    private int totalPrice;
    private String orderDate;
    private boolean signed;

    public PurchaseHistory(int id, String userId, int orderId, int totalPrice, String orderDate, boolean signed) {
        this.id = id;
        this.userId = userId;
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.signed = signed;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public boolean isSigned() {
        return signed;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }
}

