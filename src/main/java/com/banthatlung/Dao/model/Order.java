package com.banthatlung.Dao.model;

public class Order {
    private int id;
    private String name;
    private String phone;
    private String address;
    private String orderDate;
    private String update_date;
    private String Status;
    private int total_amount;

    public Order(int id, String name, String phone, String address, String orderDate, String update_date, String status, int total_amount) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.orderDate = orderDate;
        this.update_date = update_date;
        this.Status = status;
        this.total_amount = total_amount;
    }

    public Order(int id, String name, String phone, String address, String status, int total_amount) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        Status = status;
        this.total_amount = total_amount;
    }

    public Order(String name, String address, String phone, int total) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.total_amount = total;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }
}