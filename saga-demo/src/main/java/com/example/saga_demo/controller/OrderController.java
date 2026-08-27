package com.example.saga_demo.controller;

import com.example.saga_demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/{id}")
    public String create(@PathVariable String id) {

        return service.createOrder(id);

    }

}