package com.example.idempotency_demo.controller;

import com.example.idempotency_demo.entity.Order;
import com.example.idempotency_demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(
            @RequestHeader("Idempotency-Key") String idempotencyKey,
            @RequestParam String product,
            @RequestParam int quantity,
            @RequestParam double amount) {

        return orderService.createOrder(
                idempotencyKey,
                product,
                quantity,
                amount
        );
    }
}