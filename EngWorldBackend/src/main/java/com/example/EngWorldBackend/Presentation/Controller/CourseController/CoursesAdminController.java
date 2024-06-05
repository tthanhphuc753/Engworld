package com.example.EngWorldBackend.Presentation.Controller.CourseController;

import com.example.EngWorldBackend.DTO.CourseDto;
import com.example.EngWorldBackend.Domain.Model.Course;
import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import com.example.EngWorldBackend.Domain.Respones.ResponseUtils;
import com.example.EngWorldBackend.Domain.Service.CourseService.CourseService;
import com.example.EngWorldBackend.Mapper.CourseMapper;
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
@RequestMapping("/api/admin/courses")
public class CoursesAdminController {

    private final CourseService courseService;


    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addCourse(@RequestBody CourseDto newCourse) {
        try {
            courseService.createCourse(CourseMapper.toEntity(newCourse));
            return ResponseUtils.buildCreatedResponse(newCourse, CREATED_SUCCESS_RESPONES);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, BAD_REQUEST + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        List<Object> response = new ArrayList<>();

        for (Course course : courses) {
            CourseDto courseDto = CourseMapper.toDTO(course);
            response.add(courseDto);
        }
        return ResponseUtils.buildSuccessResponse(response, SUCCESS_RESPONSE);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseObject> deleteCourseById(@RequestParam long courseId) {
        try {
            courseService.deleteCourseById(courseId);
            return ResponseUtils.buildCreatedResponse(null, DELETE_SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, "Failed to delete data: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findCourseById(@PathVariable long id) {
        Optional<Course> optionalCourse = courseService.getCourseById(id);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            CourseDto courseDto = CourseMapper.toDTO(course);
            return ResponseUtils.buildSuccessResponse(courseDto, SUCCESS_RESPONSE);
        } else {
            return ResponseUtils.buildErrorResponse(HttpStatus.NOT_FOUND, NOTFOUND_RESPONSE + id);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseObject> updateCourseById(@RequestParam long id, @RequestBody Course newCourse) throws Exception {
        try {
            CourseDto courseUpdated = CourseMapper.toDTO(courseService.updateCourseById(id, newCourse));
            return ResponseUtils.buildCreatedResponse(courseUpdated, SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, BAD_REQUEST + e.getMessage());
        }
    }

    @GetMapping("/byCate/{id}")
    public ResponseEntity<ResponseObject> getAllByCate(@PathVariable Long id) {
        List<Course> courses = courseService.getCourseByCate(id);
        List<Object> response = new ArrayList<>();

        for (Course course : courses) {
            CourseDto courseDto = CourseMapper.toDTO(course);
            response.add(courseDto);
        }
        return ResponseUtils.buildSuccessResponse(response, SUCCESS_RESPONSE);
    }
}