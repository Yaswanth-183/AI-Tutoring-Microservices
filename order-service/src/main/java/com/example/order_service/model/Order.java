package com.example.order_service.model;

public class Order {

    private int orderId;
    private String product;
    private double amount;
    private String status;

    public Order() {
    }

    public Order(int orderId, String product, double amount, String status) {
        this.orderId = orderId;
        this.product = product;
        this.amount = amount;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}