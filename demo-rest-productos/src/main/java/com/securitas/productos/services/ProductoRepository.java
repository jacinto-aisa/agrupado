package com.securitas.productos.services;

import java.util.ArrayList;

import com.securitas.productos.model.Producto;

public class ProductoRepository implements IProductoRepository{
    private final ArrayList<Producto> lista = new ArrayList<>();
    public ProductoRepository()
    {
        for (int i = 0; i < 100; i++)
        {
            lista.add(new Producto(i,"Producto "+i,i * 3.14));
        }
    }

    @Override
    public Producto get(int id) {
        return lista.stream().
                filter(x -> x.getId()==id).
                findFirst().
                orElse(null);
    }

    @Override
    public ArrayList<Producto> getAll() {
        return lista;
    }
    @Override
    public Boolean delete(int id)
    {
        var eliminado = lista.remove(id);
        return (eliminado != null);
    }
    @Override
    public Producto postProducto(Producto producto)
    {
        if (!exist(producto.getId()))
        {
            lista.add(producto);
            return producto;
        }
        else
        {
            return null;
        }
    }
    @Override
    public Producto putProducto(Producto producto, int id)
    {
        if (exist(id))
        {
            delete(id);
            postProducto(producto);
            return producto;
        }
        else
        {
            return null;
        }
    }

    private boolean exist(int id)
    {
        return (lista.get(id)==null); 
    }
}
