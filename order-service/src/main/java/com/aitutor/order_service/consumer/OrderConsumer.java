package com.aitutor.order_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.aitutor.order_service.model.Order;

@Component
public class OrderConsumer {

    @RabbitListener(queues = "order.queue")
    public void receive(Order order) {

        System.out.println("--------------------------------");

        System.out.println("Processing Order");

        System.out.println(order.getOrderId());

        throw new RuntimeException("Payment Service Failed");

    }

}