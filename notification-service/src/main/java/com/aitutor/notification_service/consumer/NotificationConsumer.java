package com.aitutor.notification_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receive(String message) {

        System.out.println("================================");

        System.out.println("Notification Service");

        System.out.println(message);

        System.out.println("Email Notification Sent");

        System.out.println("================================");

    }

}