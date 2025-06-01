package com.securitas.model;

public class OrderItem {
        private int OrderId;
        private int Id;
        private int ProductId;
        private int Quantity;
        private double Price;

    public OrderItem(int orderId, int id, int productId, int quantity, double price) {
        OrderId = orderId;
        Id = id;
        ProductId = productId;
        Quantity = quantity;
        Price = price;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}

