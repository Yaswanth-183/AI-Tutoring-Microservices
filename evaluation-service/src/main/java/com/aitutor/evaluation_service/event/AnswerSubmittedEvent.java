package com.aitutor.evaluation_service.event;

public class AnswerSubmittedEvent {

    private Long submissionId;
    private String studentName;
    private Long questionId;
    private String answer;

    public AnswerSubmittedEvent() {
    }

    public AnswerSubmittedEvent(Long submissionId,
                                String studentName,
                                Long questionId,
                                String answer) {

        this.submissionId = submissionId;
        this.studentName = studentName;
        this.questionId = questionId;
        this.answer = answer;
    }

    public Long getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Long submissionId) {
        this.submissionId = submissionId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}