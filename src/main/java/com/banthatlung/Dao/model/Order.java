package com.banthatlung.Dao.model;

public class Order {
    private int id;
    private String userId;
    private int orderCode;
    private int totalPrice;
    private String orderDate;
    private int status;
    private boolean signed;
    private String signature;

    public Order(int id, String userId, int orderCode, int totalPrice, String orderDate, int status, boolean signed, String signature) {
        this.id = id;
        this.userId = userId;
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.status = status;
        this.signed = signed;
        this.signature = signature;
    }

    public Order(String userId, int orderCode, int totalPrice) {
        this.userId = userId;
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
        this.status = 1;
    }

    public int getId() { return id; }
    public String getUserId() { return userId; }
    public int getOrderCode() { return orderCode; }
    public int getTotalPrice() { return totalPrice; }
    public String getOrderDate() { return orderDate; }
    public int getStatus() { return status; }
    public boolean isSigned() { return signed; }
    public String getSignature() { return signature; }

    public void setId(int id) { this.id = id; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setOrderCode(int orderCode) { this.orderCode = orderCode; }
    public void setTotalPrice(int totalPrice) { this.totalPrice = totalPrice; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }
    public void setStatus(int status) { this.status = status; }
    public void setSigned(boolean signed) { this.signed = signed; }
    public void setSignature(String signature) { this.signature = signature; }
}
