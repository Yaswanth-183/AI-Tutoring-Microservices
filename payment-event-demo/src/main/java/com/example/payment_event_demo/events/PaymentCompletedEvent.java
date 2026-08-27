package com.example.payment_event_demo.events;

public class PaymentCompletedEvent {

    private String orderId;

    public PaymentCompletedEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}