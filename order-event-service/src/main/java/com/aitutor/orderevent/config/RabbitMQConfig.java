package com.aitutor.orderevent.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE =
            "order.exchange";

    public static final String QUEUE =
            "order.events";

    public static final String ROUTING_KEY =
            "order.created";


    @Bean
    public DirectExchange orderExchange() {

        return new DirectExchange(
                EXCHANGE,
                true,
                false
        );
    }


    @Bean
    public Queue orderQueue() {

        return new Queue(
                QUEUE,
                true
        );
    }


    @Bean
    public Binding orderBinding() {

        return BindingBuilder
                .bind(orderQueue())
                .to(orderExchange())
                .with(ROUTING_KEY);
    }


    @Bean
    public MessageConverter messageConverter() {

        return new JacksonJsonMessageConverter();
    }
}