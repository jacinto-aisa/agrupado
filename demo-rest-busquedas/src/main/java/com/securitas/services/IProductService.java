package com.securitas.services;

import org.springframework.cloud.openfeign.FeignClient;

import com.securitas.model.Producto;

@FeignClient("ProductService")
public interface IProductService {
     Producto get(int id);
}
