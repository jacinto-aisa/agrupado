package com.securitas.services;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.securitas.model.Producto;

@Service
public class ProductServiceImpl implements IProductService{
    @Override
    public Producto get(int id) {
        RestClient restClient = RestClient.builder()
        .build();
        return restClient.get()
                .uri("http://localhost:8080/Productos/Get/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Producto.class);
    }

}
