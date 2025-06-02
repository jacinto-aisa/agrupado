package com.securitas.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.securitas.model.Customer;

@FeignClient(name="CustomerService",url="http://localhost:8080/Clientes")
public interface ICustomerService  {
        @RequestMapping(method = RequestMethod.GET,value="/Get/{id}",consumes = "application/json")
        Customer get(int id);
}
