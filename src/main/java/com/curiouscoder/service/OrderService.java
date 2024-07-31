package com.curiouscoder.service;

import com.curiouscoder.entity.OrderClass;
import com.curiouscoder.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    //Create order
    public OrderClass createOder(OrderClass order) {
        return orderRepository.save(order);
    }


    //Update user
    public OrderClass updateOrder(int id , OrderClass order) {

        OrderClass order1 = orderRepository.findById(id).orElse(null);
        if(order1 != null) {
            return orderRepository.save(order);
        }

        return null;
    }


    //Get by id
    public OrderClass getById(int id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("No resource found " + id));
    }


    //Get all
    public List<OrderClass> allOrders() {
        return orderRepository.findAll();
    }


    //Delete
    public boolean deleteOrder(int id) {
        OrderClass order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("No resource found " + id));
        if(order != null) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
