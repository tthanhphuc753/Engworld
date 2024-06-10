package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.Course.CourseDto;
import com.example.EngWorldBackend.DTO.Course.CourseResponse;
import com.example.EngWorldBackend.Domain.Model.Course;
import org.springframework.data.domain.Page;

import java.util.List;

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

    public static CourseResponse mapToCourseResponse(List<CourseDto> courseDtos, Page<Course> courses) {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setContent(courseDtos);
        courseResponse.setPageNumber(courses.getNumber());
        courseResponse.setPageSize(courses.getSize());
        courseResponse.setTotalElements(courses.getTotalElements());
        courseResponse.setTotalPages(courses.getTotalPages());
        courseResponse.setLast(courses.isLast());

        return courseResponse;
    }
}
