package com.example.acid_invariant_demo.controller;

import com.example.acid_invariant_demo.entity.Order;
import com.example.acid_invariant_demo.service.OrderService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {

        Order savedOrder = orderService.createOrder(order);

        return ResponseEntity.ok(savedOrder);
    }
}