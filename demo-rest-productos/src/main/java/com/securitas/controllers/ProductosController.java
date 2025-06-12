package com.securitas.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitas.model.Producto;
import com.securitas.services.IProductoRepository;
import com.securitas.services.ProductoRepository;

@RestController
@RequestMapping("/Productos")
public class ProductosController {
    private final IProductoRepository repositorio;
    public ProductosController() {
        repositorio = new ProductoRepository();
    }

    @GetMapping("/Get/{id}")
    public ResponseEntity<?> get(@PathVariable int id)
    {
        var elemento = repositorio.get(id);
        if (elemento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Producto().toString() + id);
        } else {
            return ResponseEntity.ok(elemento);
        }
    }
    @GetMapping("/GetAll")
    public ResponseEntity<List<Producto>> getAll()
    {
        var resultado = repositorio.getAll();
        return ResponseEntity.ok(resultado);
    }
    @PostMapping("/PostProducto")
    public ResponseEntity<String> postProducto(@RequestBody Producto product)
    {
        if (exist(product.getId()))
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto ya existe con ese Id" + product.getId());
        }
        else {
            repositorio.postProducto(product);
            return ResponseEntity.status(HttpStatus.CREATED).body("Producto creado");
        }
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable int id)
    {
        if (Boolean.FALSE.equals(repositorio.delete(id))){
            return ResponseEntity.ok().body("Cliente eliminado con exito");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no existe con ese Id" + id);
        }
    }

    @PutMapping("/Put/{product}/{id}")
    public Producto putProducto(@RequestBody Producto product,
                                @PathVariable int id)
    {
        return repositorio.putProducto(product,id);
    }

    @PatchMapping("/Patch/{product}")
    public Producto patchProducto(@RequestBody Producto product)
    {
        return putProducto(product,product.getId());
    }
    private boolean exist(int id)
    {
        return repositorio.get(id) != null;
    }
}
