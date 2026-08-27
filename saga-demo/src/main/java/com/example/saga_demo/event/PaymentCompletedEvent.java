package com.example.saga_demo.event;

public class PaymentCompletedEvent {

    private String orderId;

    public PaymentCompletedEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}