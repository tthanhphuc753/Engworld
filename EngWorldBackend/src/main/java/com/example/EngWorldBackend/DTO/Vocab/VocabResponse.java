package com.example.EngWorldBackend.DTO.Vocab;

import lombok.Data;

import java.util.List;


@Data
public class VocabResponse{

    private List<VocabularyDto> content;
    private int pageNumber;
    private int pageSize;
    private Long totalElements;
    private int totalPages;
    private boolean last;
}
