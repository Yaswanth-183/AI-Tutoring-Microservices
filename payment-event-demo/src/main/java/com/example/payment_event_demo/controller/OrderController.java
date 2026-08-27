package com.example.payment_event_demo.controller;

import com.example.payment_event_demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/{id}/payment")
    public String paymentCompleted(@PathVariable String id) {

        return service.completePayment(id);

    }
}