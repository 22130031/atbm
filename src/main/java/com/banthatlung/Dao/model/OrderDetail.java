package com.banthatlung.Dao.model;

public class OrderDetail {
    private int id;
    private String userId;
    private int order_id;
    private int product_id;
    private String productName; // từ JOIN bảng product
    private int quantity;
    private int price;
    private String created_at;
    private String updated_at;

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public OrderDetail(int id, String userId, int orderId, int productId, String productName, int quantity, int price) {
        this.id = id;
        this.userId = userId;
        this.order_id = orderId;
        this.product_id = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public OrderDetail(int id, int order_id, int product_id, int quantity, int price, String created_at, String updated_at) {
        this.id = id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public OrderDetail(int order_id,String userId ,int product_id, int quantity, int price) {
        this.userId = userId;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
    }
    public String getUserId() { return userId; }
    public String getProductName() { return productName; }
    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
