package com.aitutor.payment_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.aitutor.payment_service.event.OrderCreatedEvent;

@Component
public class PaymentConsumer {

    @RabbitListener(queues = "order.created.queue")
    public void receive(OrderCreatedEvent event) {

        System.out.println("--------------------------------");

        System.out.println("Payment Service Received Event");

        System.out.println("Order ID : " + event.getOrderId());

        System.out.println("Customer : " + event.getCustomerName());

        System.out.println("Product : " + event.getProductName());

        System.out.println("Quantity : " + event.getQuantity());

        System.out.println("Payment Processed Successfully");

        System.out.println("--------------------------------");

    }
}