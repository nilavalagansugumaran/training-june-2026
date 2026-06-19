package com.example.demoSpringSecurity.service;

import com.example.demoSpringSecurity.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demoSpringSecurity.model.Orders;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class OrderServiceTest {

    @MockitoBean
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;

    @Test
    void shouldSuccessfullyCreateOrder() {
        Orders request = new Orders();
        request.setDetails("Something");
        request.setTotal(2000.00d);

        when(orderRepository.save(any())).thenReturn(new Orders());

        Orders createdOrder = orderService.createOrder(request);

        assertNotNull(createdOrder);

    }
}