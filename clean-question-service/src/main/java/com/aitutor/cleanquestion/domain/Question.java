package com.aitutor.cleanquestion.domain;

public class Question {

    private final Long id;

    private String questionText;

    private String topic;

    private String difficulty;

    private boolean active;


    public Question(
            Long id,
            String questionText,
            String topic,
            String difficulty,
            boolean active) {

        if (questionText == null ||
                questionText.isBlank()) {

            throw new IllegalArgumentException(
                    "Question text cannot be empty"
            );
        }

        if (topic == null ||
                topic.isBlank()) {

            throw new IllegalArgumentException(
                    "Topic cannot be empty"
            );
        }

        if (difficulty == null ||
                difficulty.isBlank()) {

            throw new IllegalArgumentException(
                    "Difficulty cannot be empty"
            );
        }

        this.id = id;
        this.questionText = questionText;
        this.topic = topic;
        this.difficulty = difficulty;
        this.active = active;
    }


    public static Question create(
            String questionText,
            String topic,
            String difficulty) {

        return new Question(
                null,
                questionText,
                topic,
                difficulty,
                true
        );
    }


    public void deactivate() {

        if (!active) {
            throw new IllegalStateException(
                    "Question is already inactive"
            );
        }

        this.active = false;
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
}