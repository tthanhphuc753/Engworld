package com.example.EngWorldBackend.Domain.Service.CourseService;

import com.example.EngWorldBackend.Domain.Model.Course;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course createCourse(Course course);

    Page<Course> getAllCourses(int pageNumber, int pageSize);

    Optional<Course> getCourseById(Long courseId);

    Course updateCourseById(Long courseId, Course updatedCourse);

    void deleteCourseById(Long courseId);

    Page<Course> getCourseByCate(Long cateId,int pageNumber, int pageSize);
}
