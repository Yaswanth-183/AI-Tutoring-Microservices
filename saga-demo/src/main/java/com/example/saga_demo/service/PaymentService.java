package com.example.saga_demo.service;

import com.example.saga_demo.event.OrderCreatedEvent;
import com.example.saga_demo.event.PaymentCompletedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final ApplicationEventPublisher publisher;

    public PaymentService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @EventListener
    public void processPayment(OrderCreatedEvent event) {

        System.out.println("Processing Payment for Order : "
                + event.getOrderId());

        System.out.println("Payment Successful");

        publisher.publishEvent(
                new PaymentCompletedEvent(event.getOrderId())
        );

    }

}