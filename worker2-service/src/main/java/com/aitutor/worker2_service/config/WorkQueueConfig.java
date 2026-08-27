package com.aitutor.worker2_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkQueueConfig {

    public static final String QUEUE_NAME = "evaluation.queue";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

}