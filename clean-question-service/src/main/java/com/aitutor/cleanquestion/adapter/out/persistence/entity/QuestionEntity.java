package com.aitutor.cleanquestion.adapter.out.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class QuestionEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            length = 500)
    private String questionText;

    @Column(
            nullable = false,
            length = 100)
    private String topic;

    @Column(
            nullable = false,
            length = 30)
    private String difficulty;

    @Column(nullable = false)
    private boolean active;


    protected QuestionEntity() {
    }


    public QuestionEntity(
            String questionText,
            String topic,
            String difficulty,
            boolean active) {

        this.questionText = questionText;
        this.topic = topic;
        this.difficulty = difficulty;
        this.active = active;
    }


    public Long getId() {
        return id;
    }


    public String getQuestionText() {
        return questionText;
    }


    public String getTopic() {
        return topic;
    }


    public String getDifficulty() {
        return difficulty;
    }


    public boolean isActive() {
        return active;
    }


    public void setQuestionText(
            String questionText) {

        this.questionText = questionText;
    }


    public void setTopic(String topic) {

        this.topic = topic;
    }


    public void setDifficulty(
            String difficulty) {

        this.difficulty = difficulty;
    }


    public void setActive(boolean active) {

        this.active = active;
    }
}