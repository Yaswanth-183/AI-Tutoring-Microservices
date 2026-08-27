package com.aitutor.analytics_service.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "answer.exchange";

    public static final String QUEUE = "analytics.queue";

    @Bean
    Queue analyticsQueue() {

        return new Queue(QUEUE);

    }

    @Bean
    FanoutExchange exchange() {

        return new FanoutExchange(EXCHANGE);

    }

    @Bean
    Binding binding(Queue analyticsQueue,
                    FanoutExchange exchange) {

        return BindingBuilder
                .bind(analyticsQueue)
                .to(exchange);

    }

}