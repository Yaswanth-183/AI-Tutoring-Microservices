package com.aitutor.order_service.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Main Queue
    public static final String ORDER_QUEUE = "order.queue";

    // Dead Letter Queue
    public static final String DLQ = "order.dlq";

    // Dead Letter Exchange
    public static final String DLX = "order.dlx";

    // Routing Key
    public static final String DLQ_ROUTING_KEY = "order.dlq.routing";

    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(DLX);
    }

    @Bean
    public Queue deadLetterQueue() {
        return new Queue(DLQ);
    }

    @Bean
    public Binding deadLetterBinding() {
        return BindingBuilder
                .bind(deadLetterQueue())
                .to(deadLetterExchange())
                .with(DLQ_ROUTING_KEY);
    }

    @Bean
    public Queue orderQueue() {

        Map<String, Object> args = new HashMap<>();

        args.put("x-dead-letter-exchange", DLX);

        args.put("x-dead-letter-routing-key", DLQ_ROUTING_KEY);

        return new Queue(ORDER_QUEUE, true, false, false, args);

    }

}