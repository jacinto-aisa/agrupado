package com.securitas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Order {

        private int id;
        private Date orderDate;
        private int customerId;
        private double total;

        public static final List<OrderItem> items = new ArrayList<>();

        public static List<OrderItem> getItems() {
            return items;
        }

        public void add(OrderItem item)
        {   
            items.add(item);
        }
}

