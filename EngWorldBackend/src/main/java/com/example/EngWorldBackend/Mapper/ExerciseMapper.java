package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.Exercise.ExerciseDto;
import com.example.EngWorldBackend.DTO.Exercise.ExerciseResponse;
import com.example.EngWorldBackend.Domain.Model.Exercise;
import org.springframework.data.domain.Page;

import java.util.List;

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

    public static ExerciseResponse mapToExerciseResponse(List<ExerciseDto> exerciseDtos, Page<Exercise> exercises) {
        ExerciseResponse exerciseResponse = new ExerciseResponse();
        exerciseResponse.setContent(exerciseDtos);
        exerciseResponse.setPageNumber(exercises.getNumber());
        exerciseResponse.setPageSize(exercises.getSize());
        exerciseResponse.setTotalElements(exercises.getTotalElements());
        exerciseResponse.setTotalPages(exercises.getTotalPages());
        exerciseResponse.setLast(exercises.isLast());

        return exerciseResponse;
    }
}
