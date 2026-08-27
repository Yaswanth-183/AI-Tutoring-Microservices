package com.example.idempotent_demo.controller;

import com.example.idempotent_demo.dto.OrderCreatedEvent;
import com.example.idempotent_demo.service.EventService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public String receiveEvent(@RequestBody OrderCreatedEvent event) {

        return service.processEvent(event);
    }
}