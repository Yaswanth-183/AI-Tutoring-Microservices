package com.aitutor.event_publisher_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aitutor.event_publisher_service.event.OrderCreatedEvent;
import com.aitutor.event_publisher_service.publisher.EventPublisher;

@Service
public class EventService {

    @Autowired
    private EventPublisher publisher;

    public String publishEvent(OrderCreatedEvent event) {

        publisher.publish(event);

        return "OrderCreatedEvent Published Successfully";

    }

}