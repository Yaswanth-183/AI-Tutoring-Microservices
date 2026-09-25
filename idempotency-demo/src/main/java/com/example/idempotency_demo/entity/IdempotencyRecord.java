package com.example.idempotency_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class IdempotencyRecord {

    @Id
    private String idempotencyKey;

    private Long orderId;

    public IdempotencyRecord() {
    }

    public IdempotencyRecord(String idempotencyKey, Long orderId) {
        this.idempotencyKey = idempotencyKey;
        this.orderId = orderId;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public Long getOrderId() {
        return orderId;
    }
}