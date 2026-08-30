package com.aitutor.cleanquestion.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateQuestionRequest(

        @NotBlank(
                message = "Question text is required")
        @Size(
                max = 500,
                message = "Question text cannot exceed 500 characters")
        String questionText,


        @NotBlank(
                message = "Topic is required")
        @Size(
                max = 100)
        String topic,


        @NotBlank(
                message = "Difficulty is required")
        String difficulty

) {
}