package com.interview.interview_outbox.service;

import com.interview.interview_outbox.entity.Interview;
import com.interview.interview_outbox.entity.OutboxEvent;
import com.interview.interview_outbox.repository.InterviewRepository;
import com.interview.interview_outbox.repository.OutboxEventRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;
    private final OutboxEventRepository outboxEventRepository;

    public InterviewService(
            InterviewRepository interviewRepository,
            OutboxEventRepository outboxEventRepository) {

        this.interviewRepository = interviewRepository;
        this.outboxEventRepository = outboxEventRepository;
    }

    @Transactional
    public Interview createInterview(
            String candidateName,
            String interviewerName) {

        // 1. Create Interview
        Interview interview = new Interview(
                candidateName,
                interviewerName,
                "SCHEDULED"
        );

        // 2. Save Interview
        Interview savedInterview =
                interviewRepository.save(interview);

        // 3. Create Outbox Event
        String payload =
                "Interview ID: " + savedInterview.getId()
                + ", Candidate: " + candidateName
                + ", Interviewer: " + interviewerName
                + ", Status: SCHEDULED";

        OutboxEvent event = new OutboxEvent(
                "INTERVIEW_CREATED",
                payload
        );

        // 4. Save Outbox Event
        outboxEventRepository.save(event);

        return savedInterview;
    }
}