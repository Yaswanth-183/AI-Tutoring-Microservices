package com.example.exp_10_reconciliation.service;

import com.example.exp_10_reconciliation.entity.Order;
import com.example.exp_10_reconciliation.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(
            OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public Order createPaidOrder(
            Long productId,
            int quantity,
            double amount) {

        Order order = new Order();

        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setAmount(amount);
        order.setStatus("PAID");

        LocalDateTime now = LocalDateTime.now();

        order.setCreatedAt(now);
        order.setUpdatedAt(now);
        order.setReconciliationAttempts(0);

        return orderRepository.save(order);
    }
}