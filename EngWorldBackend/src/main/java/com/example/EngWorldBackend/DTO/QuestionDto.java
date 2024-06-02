package com.example.EngWorldBackend.DTO;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.EngWorldBackend.Domain.Model.Question}
 */
@Data
public class QuestionDto implements Serializable {
    Long questionId;
    Long questionText;
    String correctAnswer;
    String op1;
    String op2;
    String op3;
}