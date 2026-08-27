package com.aitutor.worker2_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Worker2Consumer {

    @RabbitListener(queues = "evaluation.queue")
    public void processTask(String message) throws InterruptedException {

        System.out.println("================================");

        System.out.println("Worker 2 Processing");

        System.out.println(message);

        Thread.sleep(3000);

        System.out.println("Worker 2 Completed");

        System.out.println("================================");

    }

}