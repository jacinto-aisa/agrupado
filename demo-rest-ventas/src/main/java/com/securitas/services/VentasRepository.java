package com.securitas.services;

import java.util.List;

import com.securitas.model.Order;

public interface VentasRepository {
        List<Order> getAll();
        List<Order> getByCustomer(int id);
        Boolean delete(int id);
}
