package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.ExerciseDto;
import com.example.EngWorldBackend.Domain.Model.Exercise;

public class ExerciseMapper {
    public static ExerciseDto toDTO(Exercise exercise) {
        ExerciseDto dto = new ExerciseDto();
        dto.setExerciseId(exercise.getExerciseId());
        dto.setExerciseTitle(exercise.getExerciseTitle());
        dto.setLevel(exercise.getLevel());
        dto.setExerciseContent(exercise.getExerciseContent());
        dto.setTotalQuestion(exercise.getTotalQuestion());
        return dto;
    }

    public static Exercise toEntity(ExerciseDto dto) {
        Exercise exercise = new Exercise();
        exercise.setExerciseId(dto.getExerciseId());
        exercise.setExerciseTitle(dto.getExerciseTitle());
        exercise.setLevel(dto.getLevel());
        exercise.setExerciseContent(dto.getExerciseContent());
        exercise.setTotalQuestion(dto.getTotalQuestion());
        return exercise;
    }
}
