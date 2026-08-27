package com.example.payment_event_demo.listener;

import com.example.payment_event_demo.events.PaymentCompletedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentCompletedListener {

    @EventListener
    public void handlePaymentCompleted(PaymentCompletedEvent event) {

        System.out.println("Received PaymentCompletedEvent");

        System.out.println("Updating Order Status...");

        System.out.println("Order ID : " + event.getOrderId());

        System.out.println("Order Status : PAID");
    }
}