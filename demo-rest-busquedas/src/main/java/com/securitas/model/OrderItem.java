package com.securitas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class OrderItem {
        private int orderId;
        private int id;
        private int productId;
        private int quantity;
        private double price;
}

