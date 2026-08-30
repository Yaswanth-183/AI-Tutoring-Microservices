package com.interview.interview_outbox.controller;

import com.interview.interview_outbox.entity.Interview;
import com.interview.interview_outbox.service.InterviewService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interviews")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(
            InterviewService interviewService) {

        this.interviewService = interviewService;
    }

    @PostMapping
    public Interview createInterview(
            @RequestParam String candidateName,
            @RequestParam String interviewerName) {

        return interviewService.createInterview(
                candidateName,
                interviewerName
        );
    }
}