package com.securitas.services;

import java.util.List;

import com.securitas.model.Order;

public interface IVentasService {
    List<Order> get(int id);
}
