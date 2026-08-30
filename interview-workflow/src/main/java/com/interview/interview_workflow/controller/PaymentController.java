package com.interview.interview_workflow.controller;

import com.interview.interview_workflow.command.ShipOrderCommand;
import com.interview.interview_workflow.event.PaymentApprovedEvent;
import com.interview.interview_workflow.service.InterviewWorkflowService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final InterviewWorkflowService workflowService;

    public PaymentController(
            InterviewWorkflowService workflowService) {

        this.workflowService = workflowService;
    }

    @PostMapping("/approved")
    public ShipOrderCommand paymentApproved(
            @RequestBody PaymentApprovedEvent event) {

        return workflowService.processPayment(event);
    }
}