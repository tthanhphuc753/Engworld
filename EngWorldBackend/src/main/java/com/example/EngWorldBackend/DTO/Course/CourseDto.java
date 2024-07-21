package com.example.EngWorldBackend.DTO.Course;

import com.example.EngWorldBackend.Domain.Model.Course.Course;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link Course}
 */
@Data
public class CourseDto implements Serializable {
    Long courseId;
    String courseName;
    String courseLevel;
    String courseDes;
}