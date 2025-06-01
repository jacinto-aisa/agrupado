package com.securitas.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.securitas.model.Order;
import com.securitas.model.OrderItem;

@Service
public class VentasRepositoryImpl implements VentasRepository {
    private final ArrayList<Order> repo = new ArrayList<>();
    public VentasRepositoryImpl() {
        Order order01 = new Order(
                1,
                new Date(),
                1,
                100);
        order01.Add(new OrderItem(1, 1, 23, 2, 50));
        order01.Add(new OrderItem(1, 2, 4, 1, 50));
        repo.add(order01);

        Order order02 = new Order(
                2,
                new Date(),
                2,
                100);
        order02.Add(new OrderItem(2, 1, 23, 2, 50));
        order02.Add(new OrderItem(2, 2, 4, 1, 50));
        repo.add(order02);

        var Order03 = new Order(
                3,
                new Date(),
                2,
                100);
        Order03.Add(new OrderItem(3, 1, 23, 2, 50));
        Order03.Add(new OrderItem(3, 2, 4, 1, 50));
        repo.add(Order03);

        var Order04 = new Order(
                4,
                new Date(),
                3,
                50);
        Order04.Add(new OrderItem(4, 1, 5, 1, 50));
        repo.add(Order04);
    }

    @Override
    public List<Order> getAll() {
        return repo;
    }

    @Override
    public List<Order> getByCustomer(int id) {
        return repo.stream().
                filter(x->x.getCustomerId()==id).toList();
    }

    @Override
    public Boolean delete(int Id) {
        if (exist(Id)) {
            repo.remove(Id);
            return true;
        }
        return false;
    }


    private boolean exist(int id)
    {
        return repo.get(id) != null;
    }
}
