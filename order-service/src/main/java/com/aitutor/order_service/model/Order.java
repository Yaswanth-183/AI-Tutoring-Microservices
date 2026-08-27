package com.aitutor.order_service.model;

import java.io.Serializable;

public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long orderId;
    private String customerName;
    private String productName;
    private int quantity;    public Order() {
    }

    public Order(Long orderId,
                 String customerName,
                 String productName,
                 int quantity) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}