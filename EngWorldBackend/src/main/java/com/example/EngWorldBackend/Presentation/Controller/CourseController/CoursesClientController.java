package com.example.EngWorldBackend.Presentation.Controller.CourseController;

import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client/courses")
public class CoursesClientController {

    private final CoursesAdminController coursesAdminController;

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllCourses(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return coursesAdminController.getAllCourses(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findCourseById(@PathVariable long id) {
        return coursesAdminController.findCourseById(id);
    }

    @GetMapping("/byCate/{id}")
    public ResponseEntity<ResponseObject> getAllByCate(@PathVariable Long id
            , @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber
            , @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return coursesAdminController.getAllByCate(id, pageNumber, pageSize);
    }
}
