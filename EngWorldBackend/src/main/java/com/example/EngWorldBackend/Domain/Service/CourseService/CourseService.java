package com.example.EngWorldBackend.Domain.Service.CourseService;

import com.example.EngWorldBackend.Domain.Model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course createCourse(Course course);

    List<Course> getAllCourses();

    Optional<Course> getCourseById(Long courseId);

    Course updateCourseById(Long courseId, Course updatedCourse);

    void deleteCourseById(Long courseId);

    List<Course> getCourseByCate(Long cateId);
}
