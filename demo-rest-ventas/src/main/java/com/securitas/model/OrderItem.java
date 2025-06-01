package com.securitas.model;

import lombok.Data;

@Data
public class OrderItem {
    private int orderId;
    private int id;
    private int productId;
    private int quantity;
    private double price;

    public OrderItem() {
    }

    public OrderItem(int orderId, int id, int productId, int quantity, double price) {
        this.orderId = orderId;
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

