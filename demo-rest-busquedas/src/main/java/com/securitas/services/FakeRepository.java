package com.securitas.services;

import static com.securitas.model.Order.items;

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

        Order Orden1 = new Order(
                1,
                new Date(),
                1,
                100);
        Orden1.add(new OrderItem(1, 1, 23, 2, 50));
        Orden1.add(new OrderItem(1, 2, 4, 1, 50));
        listaPedidos.add(Orden1);

        var Order02 = new Order(
                2,
                new Date(),
                2,
                100);
        Order02.add(new OrderItem(2, 1, 23, 2, 50));
        Order02.add(new OrderItem(2, 2, 4, 1, 50));
        listaPedidos.add(Order02);

        var Order03 = new Order(
                3,
                new Date(),
                2,
                100);
        Order03.add(new OrderItem(3, 1, 23, 2, 50));
        Order03.add(new OrderItem(3, 2, 4, 1, 50));
        listaPedidos.add(Order03);

        var Order04 = new Order(
                4,
                new Date(),
                3,
                50);
        Order04.add(new OrderItem(4, 1, 5, 1, 50));
        listaPedidos.add(Order04);
    }


    @Override
    public Order get(int id) {
        return null;
    }

    public String muestra(int id)
    {
        var miCliente = listaCustomers.stream().
                filter(x -> x.getId()==id).
                findFirst().
                orElse(null);

        var listaPedidosCliente = listaPedidos.stream().filter(x->x.getCustomerId()==id);
        StringBuilder concatena = new StringBuilder("Resumen para el cliente de código "+id+"\n");
        concatena.append("Nombre: ").append(miCliente.getName()).append(" de: ").append(miCliente.getCity()).append("\n");
        concatena.append("""
                         Ha Realizado los siguientes pedidos:
                         """);
        for (var pedido : listaPedidosCliente.toList())
        {
            concatena.append("Pedido Nº: ").append(pedido.getId()).append(",de fecha: ").append(pedido.getOrderDate()).append("\n");
            concatena.append("Con un coste total de: ").append(pedido.getTotal()).append(", compuesto por:\n");
            for (var linea : items)
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
