package com.securitas.services;

import com.securitas.model.Order;

public interface IBusquedaRepository {
    Order Get(int Id);
}
