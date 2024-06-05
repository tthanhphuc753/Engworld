package com.example.EngWorldBackend.Presentation.Controller.CourseController;

import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client/courses")
public class CoursesClientController {

    private final CoursesAdminController coursesAdminController;

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllCourses() {
        return coursesAdminController.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findCourseById(@PathVariable long id) {
        return coursesAdminController.findCourseById(id);
    }

    @GetMapping("/byCate/{id}")
    public ResponseEntity<ResponseObject> getAllByCate(@PathVariable Long id) {
        return coursesAdminController.getAllByCate(id);
    }
}
