package com.securitas.services;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import lombok.RequiredArgsConstructor;

import com.securitas.model.Order;



@Service
@RequiredArgsConstructor
public class VentasServiceImpl implements IVentasService{
    @Override
    public List<Order> Get(int id) {
    RestClient restClient = RestClient.builder()
        .build();
        var result = restClient.get()
                .uri("http://localhost:8080/Ventas/Get/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Order[].class);
        return Arrays.stream(result).toList();
    }
}
