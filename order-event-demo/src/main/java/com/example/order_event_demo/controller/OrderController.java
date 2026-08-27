package com.example.order_event_demo.controller;

import com.example.order_event_demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/{id}")
    public String placeOrder(@PathVariable String id) {

        return service.placeOrder(id);
    }
}