package com.aitutor.questionservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateQuestionRequest(

        @NotBlank(message = "Question text is required")
        @Size(max = 500)
        String questionText,

        @NotBlank(message = "Topic is required")
        @Size(max = 100)
        String topic,

        @NotBlank(message = "Difficulty is required")
        String difficulty

) {
}