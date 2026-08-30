package com.ecommerce.ecommerce_ddd.order.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private BigDecimal totalAmount;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(Long customerId) {
        this.customerId = customerId;
        this.status = OrderStatus.CREATED;
        this.totalAmount = BigDecimal.ZERO;
    }

    /*
     * Aggregate behavior
     */
    public void addItem(OrderItem item) {

        if (item == null) {
            throw new IllegalArgumentException(
                    "Order item cannot be null"
            );
        }

        if (item.getQuantity() <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero"
            );
        }

        if (status != OrderStatus.CREATED) {
            throw new IllegalStateException(
                    "Items can only be added to a CREATED order"
            );
        }

        item.setOrder(this);

        items.add(item);

        calculateTotal();
    }

    /*
     * Calculate order total
     */
    private void calculateTotal() {

        totalAmount = items.stream()
                .map(OrderItem::getItemTotal)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }

    /*
     * Confirm order
     */
    public void confirm() {

        if (items.isEmpty()) {
            throw new IllegalStateException(
                    "Cannot confirm an empty order"
            );
        }

        if (status != OrderStatus.CREATED) {
            throw new IllegalStateException(
                    "Only CREATED orders can be confirmed"
            );
        }

        status = OrderStatus.CONFIRMED;
    }

    /*
     * Cancel order
     */
    public void cancel() {

        if (status == OrderStatus.CONFIRMED) {
            throw new IllegalStateException(
                    "Confirmed order cannot be cancelled"
            );
        }

        if (status == OrderStatus.CANCELLED) {
            throw new IllegalStateException(
                    "Order is already cancelled"
            );
        }

        status = OrderStatus.CANCELLED;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}