package com.example.idempotent_demo.service;

import com.example.idempotent_demo.dto.OrderCreatedEvent;
import com.example.idempotent_demo.entity.ProcessedEvent;
import com.example.idempotent_demo.repository.ProcessedEventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final ProcessedEventRepository repository;

    public EventService(ProcessedEventRepository repository) {
        this.repository = repository;
    }

    public String processEvent(OrderCreatedEvent event) {

        if (repository.existsById(event.getEventId())) {

            return "Duplicate Event Ignored";
        }

        System.out.println("Processing Order : " + event.getOrderId());

        repository.save(new ProcessedEvent(event.getEventId()));

        return "Event Processed Successfully";
    }
}