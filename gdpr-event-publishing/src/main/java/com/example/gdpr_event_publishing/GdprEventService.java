package com.example.gdpr_event_publishing;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class GdprEventService {

    public Map<String, Object> publishEvent(Map<String, Object> data) {

        return Map.of(
            "userId", data.get("userId"),
            "action", data.get("action"),
            "status", "Event published without personal data"
        );
    }
}