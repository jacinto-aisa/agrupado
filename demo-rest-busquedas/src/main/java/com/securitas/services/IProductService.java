package com.securitas.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.securitas.model.Producto;

@FeignClient(name="demo-rest-productos",url="http://localhost:50002/Productos")
public interface IProductService {
     @GetMapping("/Get/{id}")
     public Producto get(@PathVariable("id") int id);
}
