package com.example.EngWorldBackend.Domain.Service.ExerciseService;

import com.example.EngWorldBackend.Domain.Model.Exercise;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {
    Exercise createExercise(Exercise exercise);

    Page<Exercise> getAllExercises(int pageNumber, int pageSize);

    Optional<Exercise> getExerciseById(Long exerciseId);

    Exercise updateExerciseById(Long Id, Exercise updatedExercise);


    void deleteExercise(Long exerciseId);
}