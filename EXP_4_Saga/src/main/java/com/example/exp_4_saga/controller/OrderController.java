package com.example.exp_4_saga.controller;

import com.example.exp_4_saga.entity.Order;
import com.example.exp_4_saga.service.SagaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final SagaService sagaService;

    public OrderController(SagaService sagaService) {
        this.sagaService = sagaService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return sagaService.placeOrder(order);
    }
}