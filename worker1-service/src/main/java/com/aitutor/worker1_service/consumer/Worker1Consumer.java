package com.aitutor.worker1_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Worker1Consumer {

    @RabbitListener(queues = "evaluation.queue")
    public void processTask(String message) throws InterruptedException {

        System.out.println("================================");

        System.out.println("Worker 1 Processing");

        System.out.println(message);

        Thread.sleep(3000);

        System.out.println("Worker 1 Completed");

        System.out.println("================================");

    }

}