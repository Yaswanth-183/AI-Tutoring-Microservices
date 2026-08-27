package com.example.idempotent_demo.dto;

public class OrderCreatedEvent {

    private String eventId;
    private String orderId;

    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(String eventId, String orderId) {
        this.eventId = eventId;
        this.orderId = orderId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}