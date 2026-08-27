package com.aitutor.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aitutor.order_service.model.Order;
import com.aitutor.order_service.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public String placeOrder(
            @RequestBody Order order) {

        return service.placeOrder(order);

    }

}