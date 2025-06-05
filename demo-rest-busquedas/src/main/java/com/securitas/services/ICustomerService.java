package com.securitas.services;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.securitas.model.Customer;
@FeignClient(name="demo-rest-clientes",url = "http://localhost:50001/Clientes")
public interface ICustomerService  {
        @GetMapping("/Get/{id}")
        public Customer get(@PathVariable("id") int id);
}
