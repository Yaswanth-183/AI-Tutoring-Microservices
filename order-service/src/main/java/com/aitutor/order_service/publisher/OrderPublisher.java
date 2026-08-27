package com.aitutor.order_service.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aitutor.order_service.config.RabbitMQConfig;
import com.aitutor.order_service.model.Order;

@Component
public class OrderPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publish(Order order) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.ORDER_QUEUE,
                order);

        System.out.println("Order Published : " + order.getOrderId());

    }

}