package com.securitas.controllers;


import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitas.model.Customer;
import com.securitas.services.CustomerRepository;
import com.securitas.services.CustomerRepositoryImpl;


@RestController
@RequestMapping ("/Clientes")
public class ClientesController {
    CustomerRepository repositorio = new CustomerRepositoryImpl(); 
    @GetMapping("/Get/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        var elemento = repositorio.get(id);
        if (elemento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Customer().toString() + id);
        } else {
            return ResponseEntity.ok(elemento);
        }

    }
    @GetMapping("/GetAll")
    public ResponseEntity<List<Customer>> getAll()
    {
        var resultado = repositorio.getAll();
        return ResponseEntity.ok(resultado);

    }

    @PostMapping()
    public ResponseEntity<String> postCustomer(@RequestBody Customer customer)
    {
        if (exist(customer.getId()))
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente ya existe con ese Id" + customer.getId());
        }
        else {
            repositorio.postProducto(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id)
    {
        if (Boolean.FALSE.equals(repositorio.delete(id))){
            return ResponseEntity.ok().body("Cliente eliminado con exito");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no existe con ese Id" + id);
        }
    }

    @PutMapping("/{customer}/{id}")
    public Customer putCustomer(@PathVariable Customer customer,
                                @PathVariable int id)
    {
        return repositorio.put(customer,id);
    }

    private boolean exist(int id)
    {
        return repositorio.get(id) != null;
    }
}
