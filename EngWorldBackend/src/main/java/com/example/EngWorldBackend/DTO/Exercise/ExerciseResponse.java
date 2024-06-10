package com.example.EngWorldBackend.DTO.Exercise;

import lombok.Data;

import java.util.List;

@Data
public class ExerciseResponse {
    private List<ExerciseDto> content;
    private int pageNumber;
    private int pageSize;
    private Long totalElements;
    private int totalPages;
    private boolean last;
}
