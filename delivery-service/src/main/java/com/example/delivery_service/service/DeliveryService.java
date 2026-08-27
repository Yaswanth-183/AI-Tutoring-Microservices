package com.example.delivery_service.service;

import com.example.delivery_service.model.Delivery;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    public Delivery deliver(Delivery delivery) {

        delivery.setDeliveryStatus("OUT_FOR_DELIVERY");

        return delivery;
    }
}