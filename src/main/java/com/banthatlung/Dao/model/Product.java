package com.banthatlung.Dao.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    // loai
    private int price;
    private String description;// gia (decimal(10, 2))
    private int quantity;       // so_luong
    private int status;
    private String createdDate;
    private String image;
    private Category category;
    private Brand brand;
    private Material material;





    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Product(int i, String aNew, int i1, String dsa, int i2, int i3, String s, Category category, Brand brand, Material material) {
        this.id = i;
        this.name = aNew;
        this.price = i1;
        this.description = dsa;
        this.quantity = i2;
        this.status = i3;
        this.category = category;
        this.brand = brand;
        this.material = material;

    }

    public Product(String name, int price, String description, int quantity, int status, String image, Category category, Brand brand, Material material) {

        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.status = status;
        this.image = image;
        this.category = category;
        this.brand = brand;
        this.material = material;
    }

    public Product(int id, String name, int price, String description, int quantity, int status, String createdDate, String image, Category category, Brand brand, Material material) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.status = status;
        this.createdDate = createdDate;
        this.image = image;
        this.category = category;
        this.brand = brand;
        this.material = material;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
