package com.example.delivery_service.controller;

import com.example.delivery_service.model.Delivery;
import com.example.delivery_service.service.DeliveryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService service;

    public DeliveryController(DeliveryService service) {
        this.service = service;
    }

    @PostMapping
    public Delivery startDelivery(@RequestBody Delivery delivery) {
        return service.deliver(delivery);
    }
}