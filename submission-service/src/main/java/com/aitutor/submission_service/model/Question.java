package com.aitutor.submission_service.model;

public class Question {

    private Long questionId;
    private String questionText;
    private String difficulty;

    public Question() {
    }

    public Question(Long questionId, String questionText, String difficulty) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.difficulty = difficulty;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}