package com.aitutor.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aitutor.order_service.model.Order;
import com.aitutor.order_service.publisher.OrderPublisher;

@Service
public class OrderService {

    @Autowired
    private OrderPublisher publisher;

    public String placeOrder(Order order) {

        publisher.publish(order);

        return "Order Published Successfully";

    }

}