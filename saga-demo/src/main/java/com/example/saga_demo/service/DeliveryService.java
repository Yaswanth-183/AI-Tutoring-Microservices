package com.example.saga_demo.service;

import com.example.saga_demo.event.DeliveryStartedEvent;
import com.example.saga_demo.event.PaymentCompletedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    private final ApplicationEventPublisher publisher;

    public DeliveryService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @EventListener
    public void startDelivery(PaymentCompletedEvent event) {

        System.out.println("Starting Delivery for Order : "
                + event.getOrderId());

        publisher.publishEvent(
                new DeliveryStartedEvent(event.getOrderId())
        );

        System.out.println("Delivery Started");

    }

}