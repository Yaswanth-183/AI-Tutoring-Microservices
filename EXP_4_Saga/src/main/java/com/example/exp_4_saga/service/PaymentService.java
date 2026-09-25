package com.example.exp_4_saga.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public boolean makePayment(double amount) {

        System.out.println(
                "Payment successful: Rs." + amount
        );

        return true;
    }

    public void refund(double amount) {

        System.out.println(
                "Payment refunded: Rs." + amount
        );
    }
}