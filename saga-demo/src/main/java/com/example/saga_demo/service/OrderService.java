package com.example.saga_demo.service;

import com.example.saga_demo.event.OrderCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ApplicationEventPublisher publisher;

    public OrderService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public String createOrder(String id) {

        System.out.println("Order Created : " + id);

        publisher.publishEvent(new OrderCreatedEvent(id));

        return "Order Created Successfully";
    }

}