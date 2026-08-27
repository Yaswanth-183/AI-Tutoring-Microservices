package com.aitutor.order_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.aitutor.order_service.model.Order;

@Component
public class DeadLetterConsumer {

    @RabbitListener(queues = "order.dlq")
    public void receiveFailed(Order order) {

        System.out.println("================================");

        System.out.println("Dead Letter Queue");

        System.out.println("Failed Order : "
                + order.getOrderId());

        System.out.println("================================");

    }

}