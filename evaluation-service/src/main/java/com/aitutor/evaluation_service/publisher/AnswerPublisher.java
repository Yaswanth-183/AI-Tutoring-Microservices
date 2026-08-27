package com.aitutor.evaluation_service.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aitutor.evaluation_service.config.RabbitMQConfig;

@Component
public class AnswerPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publish(String message) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                "",
                message);

        System.out.println("Published : " + message);

    }

}