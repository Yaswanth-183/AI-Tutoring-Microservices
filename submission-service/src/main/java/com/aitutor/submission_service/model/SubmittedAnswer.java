package com.aitutor.submission_service.model;

public class SubmittedAnswer {

    private String answer;
    private int marksAwarded;
    private String feedback;

    public SubmittedAnswer() {
    }

    public SubmittedAnswer(String answer, int marksAwarded, String feedback) {
        this.answer = answer;
        this.marksAwarded = marksAwarded;
        this.feedback = feedback;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getMarksAwarded() {
        return marksAwarded;
    }

    public void setMarksAwarded(int marksAwarded) {
        this.marksAwarded = marksAwarded;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}