package com.example.order_event_demo.listener;

import com.example.order_event_demo.event.OrderPlacedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderPlacedListener {

    @EventListener
    public void handleOrderPlaced(OrderPlacedEvent event) {

        System.out.println("Received OrderPlacedEvent");

        System.out.println("Order ID : " + event.getOrderId());

        System.out.println("Sending Email...");

        System.out.println("Updating Inventory...");
    }
}