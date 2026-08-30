package com.aitutor.orderevent.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aitutor.orderevent.command.CreateOrderCommand;
import com.aitutor.orderevent.entity.OrderEntity;
import com.aitutor.orderevent.event.OrderCreatedEvent;
import com.aitutor.orderevent.publisher.OrderEventPublisher;
import com.aitutor.orderevent.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderEventPublisher eventPublisher;


    public OrderService(
            OrderRepository orderRepository,
            OrderEventPublisher eventPublisher) {

        this.orderRepository = orderRepository;

        this.eventPublisher = eventPublisher;
    }


    @Transactional
    public OrderCreatedEvent createOrder(
            CreateOrderCommand command) {

        validate(command);


        /*
         * Step 1:
         * Save the order
         */
        OrderEntity order =
                new OrderEntity(

                        command.customerId(),

                        command.productName(),

                        command.quantity(),

                        command.amount()
                );


        OrderEntity savedOrder =
                orderRepository.save(order);


        /*
         * Step 2:
         * Create domain event
         */
        OrderCreatedEvent event =
                new OrderCreatedEvent(

                        UUID.randomUUID().toString(),

                        command.correlationId(),

                        savedOrder.getId(),

                        savedOrder.getCustomerId(),

                        savedOrder.getProductName(),

                        savedOrder.getQuantity(),

                        savedOrder.getAmount(),

                        Instant.now()
                );


        /*
         * Step 3:
         * Publish event to RabbitMQ
         */
        eventPublisher.publishOrderCreated(event);


        return event;
    }


    private void validate(
            CreateOrderCommand command) {

        if (command.customerId() == null) {

            throw new IllegalArgumentException(
                    "Customer ID is required"
            );
        }


        if (command.productName() == null ||
                command.productName().isBlank()) {

            throw new IllegalArgumentException(
                    "Product name is required"
            );
        }


        if (command.quantity() <= 0) {

            throw new IllegalArgumentException(
                    "Quantity must be greater than zero"
            );
        }


        if (command.amount() == null ||
                command.amount().signum() <= 0) {

            throw new IllegalArgumentException(
                    "Amount must be greater than zero"
            );
        }
    }
}