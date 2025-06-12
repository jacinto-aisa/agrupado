package com.securitas.services;

import java.util.ArrayList;

import com.securitas.model.Producto;

public interface IProductoRepository {
    Producto get(int id);
    ArrayList<Producto> getAll();
    Boolean delete(int id);
    Producto postProducto(Producto producto);
    Producto putProducto(Producto producto, int id);
}
