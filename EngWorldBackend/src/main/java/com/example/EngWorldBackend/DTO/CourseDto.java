package com.example.EngWorldBackend.DTO;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.EngWorldBackend.Domain.Model.Course}
 */
@Data
public class CourseDto implements Serializable {
    Long courseId;
    String courseName;
    String courseLevel;
    String courseDes;
}