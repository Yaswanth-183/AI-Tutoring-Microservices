package com.aitutor.submission_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aitutor.submission_service.model.Submission;
import com.aitutor.submission_service.service.SubmissionService;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @PostMapping
    public Submission createSubmission(
            @RequestBody Submission submission) {

        return submissionService.createSubmission(submission);

    }

}