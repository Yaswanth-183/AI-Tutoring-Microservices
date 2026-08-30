package com.interview.interview_workflow.event;

public class PaymentApprovedEvent {

    private String paymentId;
    private String interviewId;
    private String candidateName;
    private double amount;

    public PaymentApprovedEvent() {
    }

    public PaymentApprovedEvent(
            String paymentId,
            String interviewId,
            String candidateName,
            double amount) {

        this.paymentId = paymentId;
        this.interviewId = interviewId;
        this.candidateName = candidateName;
        this.amount = amount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(String interviewId) {
        this.interviewId = interviewId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}