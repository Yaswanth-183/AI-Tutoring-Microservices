package com.aitutor.analytics_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsConsumer {

    @RabbitListener(queues = "analytics.queue")
    public void receive(String message) {

        System.out.println("================================");

        System.out.println("Analytics Service");

        System.out.println(message);

        System.out.println("Analytics Updated Successfully");

        System.out.println("================================");

    }

}
