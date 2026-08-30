package com.interview.interview_workflow.command;

public class ShipOrderCommand {

    private String interviewId;
    private String candidateName;
    private String paymentId;
    private String status;

    public ShipOrderCommand() {
    }

    public ShipOrderCommand(
            String interviewId,
            String candidateName,
            String paymentId,
            String status) {

        this.interviewId = interviewId;
        this.candidateName = candidateName;
        this.paymentId = paymentId;
        this.status = status;
    }

    public String getInterviewId() {
        return interviewId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getStatus() {
        return status;
    }
}