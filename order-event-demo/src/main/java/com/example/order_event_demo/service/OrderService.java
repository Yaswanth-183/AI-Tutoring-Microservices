package com.example.order_event_demo.service;

import com.example.order_event_demo.event.OrderPlacedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ApplicationEventPublisher publisher;

    public OrderService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public String placeOrder(String orderId) {

        System.out.println("Order Created : " + orderId);

        publisher.publishEvent(new OrderPlacedEvent(orderId));

        return "Order Placed Successfully";
    }
}