package com.example.demoSpringSecurity.controller;

import com.example.demoSpringSecurity.model.Orders;
import com.example.demoSpringSecurity.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order", produces = {"application/json"})
public class OrderController {

    private OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Orders createOrder(@RequestBody Orders orders) {

        return service.createOrder(orders);
    }

    @RequestMapping(method = RequestMethod.GET, path="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Orders getOrder(@PathVariable Integer id) {

        return service.getOrder(id);
    }


    @RequestMapping(method = RequestMethod.DELETE,  path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Integer id) {

        service.deleteOrder(id);
    }

    @RequestMapping(method = RequestMethod.PUT,  path="/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateOrder(@PathVariable Integer id, @RequestBody Orders orders) {
        service.updateOrder(id, orders);
    }
}
