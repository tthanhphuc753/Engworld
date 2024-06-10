package com.example.EngWorldBackend.DTO.Question;

import lombok.Data;

import java.util.List;

@Data
public class QuestionResponse {
    private List<QuestionDto> content;
    private int pageNumber;
    private int pageSize;
    private Long totalElements;
    private int totalPages;
    private boolean last;
}
