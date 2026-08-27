package com.aitutor.event_publisher_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aitutor.event_publisher_service.event.OrderCreatedEvent;
import com.aitutor.event_publisher_service.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @PostMapping("/publish")
    public String publishEvent(
            @RequestBody OrderCreatedEvent event) {

        return service.publishEvent(event);

    }

}