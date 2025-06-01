package com.securitas.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitas.model.Order;
import com.securitas.services.VentasRepository;
import com.securitas.services.VentasRepositoryImpl;

@RestController
@RequestMapping ("/Ventas")
public class VentasController {
    VentasRepository repositorio;
    public VentasController(VentasRepository repositorio) {
        this.repositorio = new VentasRepositoryImpl();
    }

    @GetMapping("/Get/{id}")
    public ResponseEntity<?> get(@PathVariable int id)
    {
        var elemento = this.repositorio.getByCustomer(id);
        if (elemento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con Id" + id);
        } else {
            return ResponseEntity.ok(elemento);
        }
    }
    @GetMapping()
    public List<Order> getAll()
    {
        return repositorio.getAll();
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteVentas(@PathVariable int Id)
    {
        if (repositorio.delete(Id)) {
            return ResponseEntity.ok().body("Venta borrada satisfactoriamente");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venta no existe con ese Id" + Id);
        }
    }
    @PatchMapping("")
    public void Patch()
    {

    }

}
