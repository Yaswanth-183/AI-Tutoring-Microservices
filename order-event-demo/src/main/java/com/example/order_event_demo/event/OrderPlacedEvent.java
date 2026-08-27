package com.example.order_event_demo.event;

public class OrderPlacedEvent {

    private String orderId;

    public OrderPlacedEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}