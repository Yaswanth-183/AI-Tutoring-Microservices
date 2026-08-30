package com.interview.interview_outbox.service;

import com.interview.interview_outbox.entity.OutboxEvent;
import com.interview.interview_outbox.repository.OutboxEventRepository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutboxProcessor {

    private final OutboxEventRepository outboxEventRepository;

    public OutboxProcessor(
            OutboxEventRepository outboxEventRepository) {

        this.outboxEventRepository = outboxEventRepository;
    }

    @Scheduled(fixedDelay = 5000)
    public void processEvents() {

        List<OutboxEvent> events =
                outboxEventRepository.findByProcessedFalse();

        for (OutboxEvent event : events) {

            System.out.println(
                    "Processing Event: "
                    + event.getEventType()
            );

            System.out.println(
                    "Payload: "
                    + event.getPayload()
            );

            event.setProcessed(true);

            outboxEventRepository.save(event);
        }
    }
}