package com.securitas.services;

import java.util.List;
import com.securitas.model.Customer;

public interface CustomerRepository
{
        Customer get(int id);
        List<Customer> getAll();
        Boolean delete(int id);
        Customer postProducto(Customer producto);
        Customer put(Customer producto, int id);
}
