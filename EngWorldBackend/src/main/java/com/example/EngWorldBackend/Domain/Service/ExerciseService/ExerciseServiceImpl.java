package com.example.EngWorldBackend.Domain.Service.ExerciseService;

import com.example.EngWorldBackend.Domain.Model.Exercise;
import com.example.EngWorldBackend.Persistence.DAO.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Override
    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public Page<Exercise> getAllExercises(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return exerciseRepository.findAll(pageable);
    }

    @Override
    public Optional<Exercise> getExerciseById(Long exerciseId) {
        return exerciseRepository.findById(exerciseId);
    }

    @Override
    public Exercise updateExerciseById(Long Id, Exercise updatedExercise) {
        Optional<Exercise> optionalExercise = exerciseRepository.findById(Id);
        if (optionalExercise.isPresent()) {
            Exercise existingExercise = optionalExercise.get();
            existingExercise.setExerciseTitle(updatedExercise.getExerciseTitle());
            existingExercise.setLevel(updatedExercise.getLevel());
            existingExercise.setExerciseContent(updatedExercise.getExerciseContent());
            existingExercise.setTotalQuestion(updatedExercise.getTotalQuestion());
            existingExercise.setCategory(updatedExercise.getCategory());
            return exerciseRepository.save(existingExercise);
        } else {
            throw new RuntimeException("Exercise not found with id: " + updatedExercise.getExerciseId());
        }
    }


    @Override
    public void deleteExercise(Long exerciseId) {
        exerciseRepository.deleteById(exerciseId);
    }

}
