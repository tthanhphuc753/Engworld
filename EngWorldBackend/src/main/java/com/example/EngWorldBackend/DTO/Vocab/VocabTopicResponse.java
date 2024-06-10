package com.example.EngWorldBackend.DTO.Vocab;

import lombok.Data;

import java.util.List;

@Data
public class VocabTopicResponse {
    private List<VocabularyTopicDto> content;
    private int pageNumber;
    private int pageSize;
    private Long totalElements;
    private int totalPages;
    private boolean last;
}
