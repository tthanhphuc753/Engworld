package com.example.EngWorldBackend.DTO.Categories;

import lombok.Data;

import java.util.List;

@Data
public class CategoriesResponse {
    private List<CategoriesDto> content;
    private int pageNumber;
    private int pageSize;
    private Long totalElements;
    private int totalPages;
    private boolean last;
}
