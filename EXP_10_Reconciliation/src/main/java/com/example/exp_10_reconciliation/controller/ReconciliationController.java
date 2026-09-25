package com.example.exp_10_reconciliation.controller;

import com.example.exp_10_reconciliation.entity.Order;
import com.example.exp_10_reconciliation.repository.OrderRepository;
import com.example.exp_10_reconciliation.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reconciliation")
public class ReconciliationController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public ReconciliationController(
            OrderService orderService,
            OrderRepository orderRepository) {

        this.orderService = orderService;
        this.orderRepository =
                orderRepository;
    }

    @PostMapping("/create-stale-order")
    public Order createStaleOrder(
            @RequestParam Long productId,
            @RequestParam int quantity,
            @RequestParam double amount) {

        return orderService.createPaidOrder(
                productId,
                quantity,
                amount
        );
    }

    @GetMapping("/orders")
    public java.util.List<Order> getOrders() {

        return orderRepository.findAll();
    }
}