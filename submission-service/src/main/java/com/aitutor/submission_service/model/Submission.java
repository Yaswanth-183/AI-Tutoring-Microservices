package com.aitutor.submission_service.model;

public class Submission {

    private Long submissionId;

    private String studentName;

    private Question question;

    private SubmittedAnswer submittedAnswer;

    public Submission() {
    }

    public Submission(Long submissionId,
                      String studentName,
                      Question question,
                      SubmittedAnswer submittedAnswer) {

        this.submissionId = submissionId;
        this.studentName = studentName;
        this.question = question;
        this.submittedAnswer = submittedAnswer;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public SubmittedAnswer getSubmittedAnswer() {
        return submittedAnswer;
    }

    public void setSubmittedAnswer(SubmittedAnswer submittedAnswer) {
        this.submittedAnswer = submittedAnswer;
    }
}