package com.securitas.model;


import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

@Data
public class Order {
    private int id;
    private Date orderDate;
    private int customerId;
    private double total;

    public Order(int id, Date orderDate, int customerId, double total) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.total = total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setItems(ArrayList<OrderItem> items) {
        Items = items;
    }

    public int getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<OrderItem> getItems() {
        return Items;
    }

    public ArrayList<OrderItem> Items = new ArrayList<>();
    public void Add(OrderItem item) {
        Items.add(item);
    }

}

