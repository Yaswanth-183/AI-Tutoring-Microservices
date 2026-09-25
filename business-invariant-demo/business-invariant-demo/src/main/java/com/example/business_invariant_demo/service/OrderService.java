package com.example.business_invariant_demo.service;

import com.example.business_invariant_demo.entity.Order;
import com.example.business_invariant_demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {

        if (order.getQuantity() <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than 0");
        }

        if (order.getPrice() <= 0) {
            throw new IllegalArgumentException(
                    "Price must be greater than 0");
        }

        order.setTotal(order.getQuantity() * order.getPrice());

        return orderRepository.save(order);
    }

    public Optional<Order> getOrder(Long id) {
        return orderRepository.findById(id);
    }
}