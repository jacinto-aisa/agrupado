package com.securitas.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.securitas.model.Order;

class VentasControllerTest {
    VentasController controlador = new VentasController();
    @Test
    void testPatch() {
        assertNotNull(controlador);
    }

    @Test
    void testDeleteVentas() {
        controlador.deleteVentas(1);
        var resultado = controlador.getAll();
        var contenido = (List<Order>) resultado.getBody();
        assertNotNull(contenido);
        assertEquals(3,contenido.size());
    }

    @Test
    void testGet() {
        var resultado = controlador.get(1);
        var contenido = (List<Order>) resultado.getBody();
        assertNotNull(contenido);
        assertEquals(1,contenido.get(0).getId());
    }

    @Test
    void testGetAll() {
        var resultado = controlador.getAll();
        var contenido = (List<Order>) resultado.getBody();
        assertNotNull(contenido);
        assertEquals(4,contenido.size());
    }
}
