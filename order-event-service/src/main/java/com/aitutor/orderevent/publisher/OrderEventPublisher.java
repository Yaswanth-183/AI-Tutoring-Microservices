package com.aitutor.orderevent.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.aitutor.orderevent.config.RabbitMQConfig;
import com.aitutor.orderevent.event.OrderCreatedEvent;

@Component
public class OrderEventPublisher {

    private final RabbitTemplate rabbitTemplate;


    public OrderEventPublisher(
            RabbitTemplate rabbitTemplate) {

        this.rabbitTemplate = rabbitTemplate;
    }


    public void publishOrderCreated(
            OrderCreatedEvent event) {

        rabbitTemplate.convertAndSend(

                RabbitMQConfig.EXCHANGE,

                RabbitMQConfig.ROUTING_KEY,

                event
        );

        System.out.println(
                "================================"
        );

        System.out.println(
                "OrderCreatedEvent Published"
        );

        System.out.println(
                "Event ID       : "
                        + event.eventId()
        );

        System.out.println(
                "Correlation ID : "
                        + event.correlationId()
        );

        System.out.println(
                "Order ID       : "
                        + event.orderId()
        );

        System.out.println(
                "================================"
        );
    }
}