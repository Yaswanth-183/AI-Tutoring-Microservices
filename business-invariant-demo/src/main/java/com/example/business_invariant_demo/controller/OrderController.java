package com.example.business_invariant_demo.controller;

import com.example.business_invariant_demo.entity.Order;
import com.example.business_invariant_demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService
                .getOrder(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));
    }
}