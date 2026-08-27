package com.example.payment_event_demo.service;

import com.example.payment_event_demo.events.PaymentCompletedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ApplicationEventPublisher publisher;

    public OrderService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public String completePayment(String orderId) {

        System.out.println("Payment completed for Order: " + orderId);

        publisher.publishEvent(new PaymentCompletedEvent(orderId));

        return "Payment Completed Event Published";
    }
}