package com.banthatlung.Dao.model;

public class ProductCart {
    private int quantity;
    private Product product;

    public ProductCart() {

    }

    public ProductCart(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void incrementQuantity() {
        quantity++;
    }
    public void decrementQuantity() {
        quantity--;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void increaseQuantity() {
        this.quantity++;
    }
}
