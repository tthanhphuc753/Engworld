package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.CourseDto;
import com.example.EngWorldBackend.Domain.Model.Course;

public class CourseMapper {
    public static CourseDto toDTO(Course course) {
        CourseDto dto = new CourseDto();
        dto.setCourseId(course.getCourseId());
        dto.setCourseName(course.getCourseName());
        dto.setCourseLevel(course.getCourseLevel());
        dto.setCourseDes(course.getCourseDes());
        return dto;
    }

    public static Course toEntity(CourseDto dto) {
        Course course = new Course();
        course.setCourseId(dto.getCourseId());
        course.setCourseName(dto.getCourseName());
        course.setCourseLevel(dto.getCourseLevel());
        course.setCourseDes(dto.getCourseDes());
        return course;
    }
}
