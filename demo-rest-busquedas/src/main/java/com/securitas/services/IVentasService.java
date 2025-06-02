package com.securitas.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import com.securitas.model.Order;

@FeignClient("VentasService")
public interface IVentasService {
    List<Order> get(int id);
}
