package com.example.EngWorldBackend.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.EngWorldBackend.Domain.Model.Exercise}
 */
@Data
public class ExerciseDto implements Serializable {
    Long exerciseId;
    String exerciseTitle;
    String level;
    String exerciseContent;
    String totalQuestion;
}