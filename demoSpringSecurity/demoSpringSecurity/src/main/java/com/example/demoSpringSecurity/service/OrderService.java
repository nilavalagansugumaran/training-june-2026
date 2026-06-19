package com.example.demoSpringSecurity.service;

import com.example.demoSpringSecurity.model.Orders;
import com.example.demoSpringSecurity.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Orders createOrder(Orders orders) {

        return orderRepository.save(orders);
    }

    public Orders getOrder(Integer id) {

        return orderRepository.findById(id).get();
    }


    public void deleteOrder(Integer id) {

        orderRepository.deleteById(id);
    }

    public void updateOrder(Integer id, Orders orders) {
        Orders orig = getOrder(id);
        orig.setDetails(orders.getDetails());
        orig.setTotal(orders.getTotal());
        orderRepository.save(orig);
    }
}
