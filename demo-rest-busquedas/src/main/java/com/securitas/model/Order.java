package com.securitas.model;

import java.util.ArrayList;
import java.util.Date;

public class Order {

        private int Id;
        private Date OrderDate;
        private int CustomerId;
        private double Total;

        public ArrayList<OrderItem> Items = new ArrayList<>();

    public Order(int id, Date orderDate, int customerId, double total) {
        Id = id;
        OrderDate = orderDate;
        CustomerId = customerId;
        Total = total;
    }

    public void Add(OrderItem item)
    {
        Items.add(item);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public ArrayList<OrderItem> getItems() {
        return Items;
    }

    public void setItems(ArrayList<OrderItem> items) {
        Items = items;
    }
}

