package com.securitas.productos.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitas.productos.model.Producto;
import com.securitas.productos.services.IProductoRepository;
import com.securitas.productos.services.ProductoRepository;

@RestController
@RequestMapping("/Productos")
public class ProductosController {
    private final IProductoRepository repositorio;
    public ProductosController() {
        repositorio = new ProductoRepository();
    }

    @GetMapping("/Get/{id}")
    public Producto get(@PathVariable int id)
    {
        return repositorio.get(id);
    }
    @GetMapping("/GetAll")
    public List<Producto> getAll()
    {
        return repositorio.getAll();
    }
    @PostMapping("/PostProducto")
    public Producto postProducto(@RequestBody Producto product)
    {
        return repositorio.postProducto(product);
    }

    @DeleteMapping("/Delete/{id}")
    public Boolean deleteProducto(@PathVariable int id)
    {
        return repositorio.delete(id);
    }

    @PutMapping("/Put/{Product}/{id}")
    public Producto putProducto(@RequestBody Producto product,
                                @PathVariable int id)
    {
        return repositorio.putProducto(product,id);
    }

    @PatchMapping("/Patch/{Product}")
    public Producto patchProducto(@RequestBody Producto product)
    {
        return putProducto(product,product.getId());
    }

}
