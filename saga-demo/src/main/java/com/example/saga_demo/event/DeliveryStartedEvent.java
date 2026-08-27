package com.example.saga_demo.event;

public class DeliveryStartedEvent {

    private String orderId;

    public DeliveryStartedEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}