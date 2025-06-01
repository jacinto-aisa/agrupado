package com.securitas.services;
import com.securitas.model.Order;

public class ServicesRepository implements IBusquedaRepository{
    private final CustomerServicdImpl servicioClientes =new CustomerServicdImpl();
    private final ProductServiceImpl servicioProductos = new ProductServiceImpl();
    private final VentasServiceImpl servicioVentas = new VentasServiceImpl();

    public String Muestra(int Id)
    {

        var miCliente = servicioClientes.get(Id);
        var listaPedidosCliente = servicioVentas.Get(Id);
        StringBuilder concatena = new StringBuilder("Resumen para el cliente de código "+Id+"\n");
        concatena.append("Nombre: ").append(miCliente.getName()).append(" de: ").append(miCliente.getCity()).append("\n");
        concatena.append("""
                         Ha Realizado los siguientes pedidos:
                         """);
        for (var pedido : listaPedidosCliente)
        {
            concatena.append("Pedido Nº: ").append(pedido.getId()).append(",de fecha: ").append(pedido.getOrderDate()).append("\n");
            concatena.append("Con un coste total de: ").append(pedido.getTotal()).append(", compuesto por:\n");
            for (var linea : pedido.Items)
            {
                var ProductoBuscado = servicioProductos.Get(linea.getProductId());
                concatena.append("producto: ").append(ProductoBuscado.getName()).append(" Cantidad: ").append(linea.getQuantity());
                concatena.append("precio: ").append(ProductoBuscado.getPrice()).append("\n");
            }

        }
        return concatena.toString();
    }

    @Override
    public Order Get(int Id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
