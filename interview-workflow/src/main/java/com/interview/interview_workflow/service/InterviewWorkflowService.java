package com.interview.interview_workflow.service;

import com.interview.interview_workflow.command.ShipOrderCommand;
import com.interview.interview_workflow.event.PaymentApprovedEvent;

import org.springframework.stereotype.Service;

@Service
public class InterviewWorkflowService {

    public ShipOrderCommand processPayment(
            PaymentApprovedEvent event) {

        System.out.println("PaymentApprovedEvent received");

        System.out.println(
                "Payment ID: " + event.getPaymentId()
        );

        System.out.println(
                "Interview ID: " + event.getInterviewId()
        );

        System.out.println(
                "Candidate: " + event.getCandidateName()
        );

        ShipOrderCommand command =
                new ShipOrderCommand(
                        event.getInterviewId(),
                        event.getCandidateName(),
                        event.getPaymentId(),
                        "INTERVIEW_PACKAGE_ACTIVATED"
                );

        System.out.println("ShipOrderCommand created");

        return command;
    }
}