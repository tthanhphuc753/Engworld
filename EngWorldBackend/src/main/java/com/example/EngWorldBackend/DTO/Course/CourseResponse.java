package com.example.EngWorldBackend.DTO.Course;

import lombok.Data;

import java.util.List;

@Data
public class CourseResponse {
    private List<CourseDto> content;
    private int pageNumber;
    private int pageSize;
    private Long totalElements;
    private int totalPages;
    private boolean last;
}
