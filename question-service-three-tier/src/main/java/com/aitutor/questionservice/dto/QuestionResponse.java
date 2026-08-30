package com.aitutor.questionservice.dto;

public record QuestionResponse(

        Long id,

        String questionText,

        String topic,

        String difficulty,

        boolean active

) {
}