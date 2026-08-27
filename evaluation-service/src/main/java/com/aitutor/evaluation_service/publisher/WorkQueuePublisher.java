package com.aitutor.evaluation_service.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aitutor.evaluation_service.config.WorkQueueConfig;

@Component
public class WorkQueuePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendTask(String message) {

        rabbitTemplate.convertAndSend(
                WorkQueueConfig.QUEUE_NAME,
                message);

        System.out.println("Task Published : " + message);

    }
}