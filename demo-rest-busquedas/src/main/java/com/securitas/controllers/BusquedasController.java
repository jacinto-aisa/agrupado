package com.securitas.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitas.model.Order;
import com.securitas.services.ICustomerService;
import com.securitas.services.IProductService;
import com.securitas.services.IVentasService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping ("/Busquedas")
public class BusquedasController {
    private final ICustomerService servicioClientes;
    private final IProductService servicioProductos;
    private final IVentasService servicioVentas; 
    @GetMapping("/Get/{id}")
    public ResponseEntity<String> get(@PathVariable int id)
    {
        var miCliente = servicioClientes.get(id);
        var listaPedidosCliente = servicioVentas.get(id);
        StringBuilder concatena = new StringBuilder("Resumen para el cliente de código "+id+"\n");
        concatena.append("Nombre: ").append(miCliente.getName()).append(" de: ").append(miCliente.getCity()).append("\n");
        concatena.append("""
                         Ha Realizado los siguientes pedidos:
                         """);
        for (var pedido : listaPedidosCliente)
        {
            concatena.append("Pedido Nº: ").append(pedido.getId()).append(",de fecha: ").append(pedido.getOrderDate()).append("\n");
            concatena.append("Con un coste total de: ").append(pedido.getTotal()).append(", compuesto por:\n");
            for (var linea : Order.items)
            {
                var productoBuscado = servicioProductos.get(linea.getProductId());
                concatena.append("producto: ").append(productoBuscado.getName()).append(" Cantidad: ").append(linea.getQuantity());
                concatena.append("precio: ").append(productoBuscado.getPrice()).append("\n");
            }

        }
        return ResponseEntity.ok(concatena.toString());
    }
}
