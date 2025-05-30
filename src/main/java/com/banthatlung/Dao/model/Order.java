package com.banthatlung.Dao.model;

public class Order {
    private int id;             // ID nội bộ
    private String userId;      // ID người dùng (VARCHAR)
    private int orderCode;      // Mã đơn hàng hiển thị
    private int totalPrice;     // Tổng tiền
    private String orderDate;   // Ngày đặt hàng
    private boolean signed;     // Đã ký hay chưa
    private int status;         // Trạng thái đơn hàng (1: mới đặt, 2: đã giao...)

    public Order(int id, String userId, int orderCode, int totalPrice, String orderDate, boolean signed, int status) {
        this.id = id;
        this.userId = userId;
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.signed = signed;
        this.status = status;
    }

    public Order(String userId, int orderCode, int totalPrice) {
        this.userId = userId;
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
        this.orderDate = null;
        this.signed = false;
        this.status = 1;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getUserId() { return userId; }
    public int getOrderCode() { return orderCode; }
    public int getTotalPrice() { return totalPrice; }
    public String getOrderDate() { return orderDate; }
    public boolean isSigned() { return signed; }
    public int getStatus() { return status; }

    public void setId(int id) { this.id = id; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setOrderCode(int orderCode) { this.orderCode = orderCode; }
    public void setTotalPrice(int totalPrice) { this.totalPrice = totalPrice; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }
    public void setSigned(boolean signed) { this.signed = signed; }
    public void setStatus(int status) { this.status = status; }
}
