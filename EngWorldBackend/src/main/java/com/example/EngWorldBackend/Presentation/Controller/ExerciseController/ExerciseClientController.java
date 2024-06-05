package com.example.EngWorldBackend.Presentation.Controller.ExerciseController;


import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client/exercise")
public class ExerciseClientController {

    private final ExerciseAdminController exerciseAdminController;
    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllExercises(){
        return exerciseAdminController.getAllExercises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findExerciseById(@PathVariable long id){
        return  exerciseAdminController.findExerciseById(id);
    }
}
