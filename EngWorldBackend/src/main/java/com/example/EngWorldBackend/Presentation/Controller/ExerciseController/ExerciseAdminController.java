package com.example.EngWorldBackend.Presentation.Controller.ExerciseController;

import com.example.EngWorldBackend.DTO.ExerciseDto;
import com.example.EngWorldBackend.Domain.Model.Exercise;
import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import com.example.EngWorldBackend.Domain.Respones.ResponseUtils;
import com.example.EngWorldBackend.Domain.Service.ExerciseService.ExerciseService;
import com.example.EngWorldBackend.Mapper.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.EngWorldBackend.Domain.Respones.ResponseMessages.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/exercise")
public class ExerciseAdminController {

    private final ExerciseService exerciseService;


    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addExercise(@RequestBody ExerciseDto newExercise) {
        try {
            exerciseService.createExercise(ExerciseMapper.toEntity(newExercise));
            return ResponseUtils.buildCreatedResponse(newExercise, CREATED_SUCCESS_RESPONES);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, BAD_REQUEST + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllExercises() {
        List<Exercise> exercises = exerciseService.getAllExercises();
        List<Object> response = new ArrayList<>();

        for (Exercise exercise : exercises) {
            ExerciseDto exerciseDto = ExerciseMapper.toDTO(exercise);
            response.add(exerciseDto);
        }
        return ResponseUtils.buildSuccessResponse(response, SUCCESS_RESPONSE);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseObject> deleteExerciseById(@RequestParam long exerciseId) {
        try {
            exerciseService.deleteExercise(exerciseId);
            return ResponseUtils.buildCreatedResponse(null, DELETE_SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, "Failed to delete data: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findExerciseById(@PathVariable long id) {
        Optional<Exercise> optionalExercise = exerciseService.getExerciseById(id);
        if (optionalExercise.isPresent()) {
            Exercise exercise = optionalExercise.get();
            ExerciseDto exerciseDto = ExerciseMapper.toDTO(exercise);
            return ResponseUtils.buildSuccessResponse(exerciseDto, SUCCESS_RESPONSE);
        } else {
            return ResponseUtils.buildErrorResponse(HttpStatus.NOT_FOUND, NOTFOUND_RESPONSE + id);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseObject> updateExerciseById(@RequestParam long id, @RequestBody Exercise newExercise) throws Exception {
        try {
            ExerciseDto exerciseUpdated = ExerciseMapper.toDTO(exerciseService.updateExerciseById(id, newExercise));
            return ResponseUtils.buildCreatedResponse(exerciseUpdated, SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, BAD_REQUEST + e.getMessage());
        }
    }
}