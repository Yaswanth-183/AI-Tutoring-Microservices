package com.example.order_service.service;

import com.example.order_service.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public Order createOrder(Order order) {

        order.setStatus("ORDER_CREATED");

        return order;
    }
}