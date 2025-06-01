package com.securitas.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.securitas.model.Customer;

class ClientesControllerTest {
    ClientesController controlador = new ClientesController();

    @Test
    void testDeleteCustomer() {
        controlador.deleteCustomer(1);
        var resultado = controlador.getAll();
        var contenido = (ArrayList<Customer>)resultado.getBody();
        assertNotNull(contenido);
        assertEquals(5, contenido.size());
    }

    @Test
    void testGet() {
        var resultado = controlador.get(1);
        var contenido = (Customer) resultado.getBody();
        assertNotNull(contenido);
        assertEquals("Rodrigo",contenido.getName());
    }

    @Test
    void testGetAll() {
        var resultado = controlador.getAll();
        var contenido = (ArrayList<Customer>)resultado.getBody();
        assertNotNull(contenido);
        assertEquals(6, contenido.size());
    }

    @Test
    void testPutCustomer() {
        controlador.putCustomer(new Customer(7,"Pepe","Zaragoza"),4);
        var resultado = controlador.getAll();
        var contenido = (ArrayList<Customer>)resultado.getBody();
        assertNotNull(contenido);
        assertEquals(6, contenido.size());
    }

    @Test
    void testPostCustomer() {
        controlador.postCustomer(new Customer(7,"Pepe","Zaragoza"));
        var resultado = controlador.getAll();
        ArrayList<Customer> contenido = (ArrayList<Customer>)resultado.getBody();
        assertNotNull(contenido);
        assertEquals(7, contenido.size());
    }
}
