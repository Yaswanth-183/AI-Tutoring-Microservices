package com.aitutor.orderevent.controller;

import java.util.UUID;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.aitutor.orderevent.command.CreateOrderCommand;
import com.aitutor.orderevent.dto.CreateOrderRequest;
import com.aitutor.orderevent.event.OrderCreatedEvent;
import com.aitutor.orderevent.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(
            OrderService orderService) {

        this.orderService = orderService;
    }


    @PostMapping
    public ResponseEntity<OrderCreatedEvent>
    createOrder(
            @Valid
            @RequestBody
            CreateOrderRequest request) {


        /*
         * Create correlation ID
         * for this request.
         */
        String correlationId =
                UUID.randomUUID().toString();


        /*
         * Convert API request
         * into a command.
         */
        CreateOrderCommand command =
                new CreateOrderCommand(

                        correlationId,

                        null,

                        request.customerId(),

                        request.productName(),

                        request.quantity(),

                        request.amount()
                );


        /*
         * Execute application operation.
         */
        OrderCreatedEvent event =
                orderService.createOrder(
                        command
                );


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(event);
    }
}