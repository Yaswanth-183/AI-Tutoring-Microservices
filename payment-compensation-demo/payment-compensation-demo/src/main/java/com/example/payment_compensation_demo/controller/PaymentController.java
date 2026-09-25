package com.example.payment_compensation_demo.controller;

import com.example.payment_compensation_demo.entity.Payment;
import com.example.payment_compensation_demo.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public Payment makePayment(
            @RequestParam String orderId,
            @RequestParam double amount) {

        return paymentService.makePayment(orderId, amount);
    }

    @PostMapping("/{id}/compensate")
    public Payment compensatePayment(@PathVariable Long id) {

        return paymentService.compensatePayment(id);
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Long id) {

        return paymentService.getPayment(id);
    }
}