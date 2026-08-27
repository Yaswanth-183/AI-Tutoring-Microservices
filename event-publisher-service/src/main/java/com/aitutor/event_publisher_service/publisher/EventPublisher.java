package com.aitutor.event_publisher_service.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aitutor.event_publisher_service.config.RabbitMQConfig;
import com.aitutor.event_publisher_service.event.OrderCreatedEvent;

@Component
public class EventPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publish(OrderCreatedEvent event) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.QUEUE_NAME,
                event);

        System.out.println("--------------------------------");

        System.out.println("OrderCreatedEvent Published");

        System.out.println("Order ID : " + event.getOrderId());

        System.out.println("--------------------------------");

    }

}