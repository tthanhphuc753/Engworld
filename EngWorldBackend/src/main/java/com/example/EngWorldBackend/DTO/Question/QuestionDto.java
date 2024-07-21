package com.example.EngWorldBackend.DTO.Question;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.EngWorldBackend.Domain.Model.Question}
 */
@Data
public class QuestionDto implements Serializable {
    Long questionId;
    String questionText;
    String correctAnswer;
    String op1;
    String op2;
    String op3;
    String ExerciseType;
}