package com.securitas.productos.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.securitas.productos.model.Producto;

public class ProductosControllerTest {
    ProductosController controlador = new ProductosController();

    @Test
    void testDeleteProducto() {
        controlador.deleteProducto(1);
        var resultado = controlador.getAll();
        var contenido = (ArrayList<Producto>)resultado.getBody();
        assertNotNull(contenido);
        assertEquals(99, contenido.size());
    }

    @Test
    void testGet() {
        var resultado = controlador.get(1);
        var contenido = (Producto) resultado.getBody();
        assertNotNull(contenido);
        assertEquals("Producto 1",contenido.getName());
    }

    @Test
    void testGetAll() {
        var resultado = controlador.getAll();
        var contenido = (ArrayList<Producto>)resultado.getBody();
        assertNotNull(contenido);
        assertEquals(100, contenido.size());
    }

    @Test
    void testPutCustomer() {
        controlador.putProducto(new Producto(76555,"prueba",7.89),7);
        var resultado = controlador.getAll();
        var contenido = (ArrayList<Producto>)resultado.getBody();
        assertNotNull(contenido);
        assertEquals(100, contenido.size());
    }

    @Test
    void testPostCustomer() {
        controlador.postProducto(new Producto(76,"prueba",7));
        var resultado = controlador.getAll();
        ArrayList<Producto> contenido = (ArrayList<Producto>)resultado.getBody();
        assertNotNull(contenido);
        assertEquals(100, contenido.size());
    }
}



  



