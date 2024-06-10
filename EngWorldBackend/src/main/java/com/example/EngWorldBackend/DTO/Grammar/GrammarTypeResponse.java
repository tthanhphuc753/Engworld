package com.example.EngWorldBackend.DTO.Grammar;

import lombok.Data;

import java.util.List;

@Data
public class GrammarTypeResponse {
    private List<GrammarTypeDto> content;
    private int pageNumber;
    private int pageSize;
    private Long totalElements;
    private int totalPages;
    private boolean last;
}
