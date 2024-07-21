package com.example.EngWorldBackend.DTO.Course;

import com.example.EngWorldBackend.Domain.Respones.PagedResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CourseResponse extends PagedResponse<CourseDto> {

}
