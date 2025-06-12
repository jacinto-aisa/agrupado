/**
 * ServicesRepository is an implementation of the IBusquedaRepository interface that provides
 * methods to retrieve and display summarized information about customers, their orders, and
 * the products associated with those orders.
 * <p>
 * This repository depends on three service interfaces:
 * <ul>
 *   <li>ICustomerService: for retrieving customer information</li>
 *   <li>IProductService: for retrieving product details</li>
 *   <li>IVentasService: for retrieving sales/orders information</li>
 * </ul>
 * </p>
 * 
 * <p>
 * The main method, {@code muestra(int id)}, generates a summary for a given customer,
 * including their personal information and a detailed list of their orders and the products
 * within each order.
 * </p>
 * 
 * <p>
 * Note: The {@code get(int id)} method is not yet implemented.
 * </p>
 * 
 * @author YourName
 */
package com.securitas.services;

import com.securitas.model.Order;

import lombok.AllArgsConstructor;

/**
 * ServicesRepository is an implementation of the IBusquedaRepository interface that provides
 * methods to retrieve and display summarized information about customers, their orders, and
 * the products associated with those orders.
 * <p>
 * This repository depends on three service interfaces:
 * <ul>
 *   <li>ICustomerService: for retrieving customer information</li>
 *   <li>IProductService: for retrieving product details</li>
 *   <li>IVentasService: for retrieving sales/orders information</li>
 * </ul>
 * </p>
 * 
 * <p>
 * The main method, {@code muestra(int id)}, generates a summary for a given customer,
 * including their personal information and a detailed list of their orders and the products
 * within each order.
 * </p>
 * 
 * <p>
 * Note: The {@code get(int id)} method is not yet implemented.
 * </p>
 * 
 * @author YourName
 */
@AllArgsConstructor
public class ServicesRepository implements IBusquedaRepository{
    private final ICustomerService servicioClientes;
    private final IProductService servicioProductos;
    private final IVentasService servicioVentas; 

    /**
     * Generates a summary report for a client, including their personal information and a list of their orders.
     * <p>
     * The summary includes:
     * <ul>
     *   <li>Client's name and city</li>
     *   <li>All orders placed by the client, with order number, date, total cost</li>
     *   <li>Details of each item in the order, including product name, quantity, and price</li>
     * </ul>
     * </p>
     *
     * @param id the unique identifier of the client whose summary is to be generated
     * @return a formatted string containing the client's summary and order details
     */
    public String muestra(int id)
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
        return concatena.toString();
    }

    /**
     * Not yet implemented. Throws UnsupportedOperationException.
     *
     * @param id the unique identifier of the order to retrieve
     * @return nothing, as this method always throws an exception
     * @throws UnsupportedOperationException always thrown, as this method is not supported yet
     */
    @Override
    public Order get(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

 
}
