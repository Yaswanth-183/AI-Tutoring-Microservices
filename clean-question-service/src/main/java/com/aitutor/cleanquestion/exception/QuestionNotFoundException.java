package com.aitutor.cleanquestion.exception;

public class QuestionNotFoundException
        extends RuntimeException {

    public QuestionNotFoundException(Long id) {

        super(
            "Question not found with id: " + id
        );
    }
}