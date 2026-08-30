package com.aitutor.orderevent.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String status;


    protected OrderEntity() {
    }


    public OrderEntity(
            Long customerId,
            String productName,
            int quantity,
            BigDecimal amount) {

        this.customerId = customerId;
        this.productName = productName;
        this.quantity = quantity;
        this.amount = amount;
        this.status = "CREATED";
    }


    public Long getId() {
        return id;
    }


    public Long getCustomerId() {
        return customerId;
    }


    public String getProductName() {
        return productName;
    }


    public int getQuantity() {
        return quantity;
    }


    public BigDecimal getAmount() {
        return amount;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {

        this.status = status;
    }
}