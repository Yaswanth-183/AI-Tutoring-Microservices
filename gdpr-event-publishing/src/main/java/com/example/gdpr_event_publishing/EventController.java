package com.example.gdpr_event_publishing;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/events")
public class EventController {

    private final GdprEventService service;

    public EventController(GdprEventService service) {
        this.service = service;
    }

    // POST
    @PostMapping
    public Map<String, Object> publish(@RequestBody Map<String, Object> data) {
        return service.publishEvent(data);
    }

    // GET
    @GetMapping("/{id}")
    public Map<String, Object> getEvent(@PathVariable int id) {
        return Map.of(
            "eventId", id,
            "action", "ORDER_CREATED",
            "status", "GDPR-safe event"
        );
    }

    // PUT
    @PutMapping("/{id}")
    public Map<String, Object> updateEvent(
            @PathVariable int id,
            @RequestBody Map<String, Object> data) {

        return Map.of(
            "eventId", id,
            "action", data.get("action"),
            "status", "Event updated without personal data"
        );
    }
}