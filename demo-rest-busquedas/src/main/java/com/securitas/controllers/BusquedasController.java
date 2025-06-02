package com.securitas.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitas.services.ServicesRepository;

@RestController
@RequestMapping ("/Busquedas")
public class BusquedasController {

    @GetMapping("/Get/{id}")
    public ResponseEntity<String> get(@PathVariable int id)
    {
        var repositorio = new ServicesRepository();
        return ResponseEntity.ok(repositorio.muestra(id));
    }


}
