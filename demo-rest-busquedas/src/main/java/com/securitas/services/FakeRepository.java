package com.securitas.services;

import java.util.ArrayList;
import java.util.Date;

import com.securitas.model.Customer;
import com.securitas.model.Order;
import com.securitas.model.OrderItem;
import com.securitas.model.Producto;



public class FakeRepository implements IBusquedaRepository{
    private final ArrayList<Customer> listaCustomers = new ArrayList<>();
    private final ArrayList<Producto> listaProductos = new ArrayList<>();
    private final ArrayList<Order> listaPedidos = new ArrayList<>();
    public FakeRepository() {
        listaCustomers.add(new Customer(1,"Rodrigo","Ciudad de México" ));
        listaCustomers.add(new Customer(2,"Renata","Lima"));
        listaCustomers.add(new Customer(3,"Raúl","Madrid"));
        listaCustomers.add(new Customer(4,"Raquel","Buenos Aires"));

        for (int i = 1; i < 101; i++)
        {
            listaProductos.add(new Producto(i,"Producto "+i,i * 3.14));
        }

        var Order01 = new Order(
                1,
                new Date(),
                1,
                100);
        Order01.Add(new OrderItem(1, 1, 23, 2, 50));
        Order01.Add(new OrderItem(1, 2, 4, 1, 50));
        listaPedidos.add(Order01);

        var Order02 = new Order(
                2,
                new Date(),
                2,
                100);
        Order02.Add(new OrderItem(2, 1, 23, 2, 50));
        Order02.Add(new OrderItem(2, 2, 4, 1, 50));
        listaPedidos.add(Order02);

        var Order03 = new Order(
                3,
                new Date(),
                2,
                100);
        Order03.Add(new OrderItem(3, 1, 23, 2, 50));
        Order03.Add(new OrderItem(3, 2, 4, 1, 50));
        listaPedidos.add(Order03);

        var Order04 = new Order(
                4,
                new Date(),
                3,
                50);
        Order04.Add(new OrderItem(4, 1, 5, 1, 50));
        listaPedidos.add(Order04);
    }


    @Override
    public Order Get(int Id) {
        return null;
    }

    public String Muestra(int Id)
    {
        var miCliente = listaCustomers.stream().
                filter(x -> x.getId()==Id).
                findFirst().
                orElse(null);

        var listaPedidosCliente = listaPedidos.stream().filter(x->x.getCustomerId()==Id);
        StringBuilder concatena = new StringBuilder("Resumen para el cliente de código "+Id+"\n");
        concatena.append("Nombre: ").append(miCliente.getName()).append(" de: ").append(miCliente.getCity()).append("\n");
        concatena.append("""
                         Ha Realizado los siguientes pedidos:
                         """);
        for (var pedido : listaPedidosCliente.toList())
        {
            concatena.append("Pedido Nº: ").append(pedido.getId()).append(",de fecha: ").append(pedido.getOrderDate()).append("\n");
            concatena.append("Con un coste total de: ").append(pedido.getTotal()).append(", compuesto por:\n");
            for (var linea : pedido.Items)
            {
                var ProductoBuscado = listaProductos.stream().filter(x->x.getId()==linea.getProductId())
                        .findFirst().orElse(null);
                concatena.append("producto: ").append(ProductoBuscado.getName()).append(" Cantidad: ").append(linea.getQuantity());
                concatena.append("precio: ").append(ProductoBuscado.getPrice()).append("\n");
            }

        }
        return concatena.toString();
    }
}
