package com.example.EngWorldBackend.Presentation.Controller.ExerciseController;


import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client/exercise")
public class ExerciseClientController {

    private final ExerciseAdminController exerciseAdminController;

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllExercises(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return exerciseAdminController.getAllExercises(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findExerciseById(@PathVariable long id) {
        return exerciseAdminController.findExerciseById(id);
    }
}
