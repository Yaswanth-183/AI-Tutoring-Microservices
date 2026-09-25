package com.example.idempotency_demo.service;

import com.example.idempotency_demo.entity.IdempotencyRecord;
import com.example.idempotency_demo.entity.Order;
import com.example.idempotency_demo.repository.IdempotencyRecordRepository;
import com.example.idempotency_demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final IdempotencyRecordRepository idempotencyRepository;

    public OrderService(OrderRepository orderRepository,
                        IdempotencyRecordRepository idempotencyRepository) {
        this.orderRepository = orderRepository;
        this.idempotencyRepository = idempotencyRepository;
    }

    public Order createOrder(String idempotencyKey,
                             String product,
                             int quantity,
                             double amount) {

        // Check whether request was already processed
        if (idempotencyRepository.existsById(idempotencyKey)) {

            IdempotencyRecord record =
                    idempotencyRepository.findById(idempotencyKey).get();

            return orderRepository.findById(record.getOrderId()).get();
        }

        // Create new order
        Order order = new Order(product, quantity, amount);

        Order savedOrder = orderRepository.save(order);

        // Save idempotency key
        IdempotencyRecord record =
                new IdempotencyRecord(idempotencyKey, savedOrder.getId());

        idempotencyRepository.save(record);

        return savedOrder;
    }
}