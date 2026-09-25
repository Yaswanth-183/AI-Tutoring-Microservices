package com.example.acid_invariant_demo.service;

import com.example.acid_invariant_demo.entity.Order;
import com.example.acid_invariant_demo.repository.OrderRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order createOrder(Order order) {

        // Step 1: Set initial status
        order.setStatus("CREATED");

        // Step 2: Save order
        Order savedOrder = orderRepository.save(order);

        // Step 3: Simulate transaction failure
        if (order.getQuantity() < 0) {
            throw new RuntimeException("Invalid quantity. Transaction rolled back.");
        }

        // Step 4: Update status
        savedOrder.setStatus("CONFIRMED");

        // Step 5: Save updated order
        return orderRepository.save(savedOrder);
    }
}