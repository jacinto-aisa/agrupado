package com.securitas.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.securitas.model.Order;

@FeignClient(name="demo-rest-ventas",url="http://localhost:50003/Ventas")
public interface IVentasService {
    @GetMapping("/Get/{id}")
    List<Order> get(@PathVariable("id") int id);
}
