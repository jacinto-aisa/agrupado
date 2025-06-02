package com.securitas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


import com.securitas.model.Customer;



public class CustomerRepositoryImpl implements CustomerRepository {


    private final List<Customer> lista = new ArrayList<>();

    public CustomerRepositoryImpl() {
        lista.add(new Customer(1, "Rodrigo", "Ciudad de México"));
        lista.add(new Customer(2, "Renata", "Lima"));
        lista.add(new Customer(3, "Raúl", "Madrid"));
        lista.add(new Customer(4, "Raquel", "Buenos Aires"));
        lista.add(new Customer(5, "Maria", "Madrid"));
        lista.add(new Customer(6, "Ambrosio", "Buenos Aires"));
    }

    @Override
    public Customer get(int id) {
        return lista.stream().
                filter(x -> x.getId() == id).
                findFirst().
                orElse(null);
    }

    @Override
    public List<Customer> getAll() {
        return lista;
    }

    @Override
    public Boolean delete(int id) {
        if (exist(id)) {
            lista.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Customer postProducto(Customer customer) {
        lista.add(customer);
        return customer;
    }

    @Override
    public Customer put(Customer customer, int id) {
        if (exist(id)) {
            delete(id);
            postProducto(customer);
            return customer;
        } else {
            return null;
        }
    }

    private boolean exist(int id) {
        return lista.get(id) != null;
    }

    public void filtrarColeccion(List<Customer> lista,
                                 Consumer<Customer> consumidor,
                                 Predicate<Customer> filtro) {
        lista.stream()
                .sorted()
                .filter(filtro)
                .forEach(consumidor);
    }
}


