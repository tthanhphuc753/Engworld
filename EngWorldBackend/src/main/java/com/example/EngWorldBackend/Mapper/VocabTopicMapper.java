package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.Vocab.VocabTopicResponse;
import com.example.EngWorldBackend.DTO.Vocab.VocabularyTopicDto;
import com.example.EngWorldBackend.Domain.Model.Vocab.VocabularyTopic;
import org.springframework.data.domain.Page;

import java.util.List;

public class VocabTopicMapper {
    public static VocabularyTopicDto toDTO(VocabularyTopic vocabularyTopic) {
        VocabularyTopicDto dto = new VocabularyTopicDto();
        dto.setVocabTopicId(vocabularyTopic.getVocabTopicId());
        dto.setTopicName(vocabularyTopic.getTopicName());
        return dto;
    }

    public static VocabularyTopic toEntity(VocabularyTopicDto dto) {
        VocabularyTopic vocabularyTopic = new VocabularyTopic();
        vocabularyTopic.setVocabTopicId(dto.getVocabTopicId());
        vocabularyTopic.setTopicName(dto.getTopicName());
        return vocabularyTopic;
    }

    public static VocabTopicResponse mapToVocabularyTopicResponse(List<VocabularyTopicDto> vocabularyTopicDtos, Page<VocabularyTopic> vocabularyTopics) {
        VocabTopicResponse vocabularyTopicResponse = new VocabTopicResponse();
        vocabularyTopicResponse.setContent(vocabularyTopicDtos);
        vocabularyTopicResponse.setPageNumber(vocabularyTopics.getNumber());
        vocabularyTopicResponse.setPageSize(vocabularyTopics.getSize());
        vocabularyTopicResponse.setTotalElements(vocabularyTopics.getTotalElements());
        vocabularyTopicResponse.setTotalPages(vocabularyTopics.getTotalPages());
        vocabularyTopicResponse.setLast(vocabularyTopics.isLast());

        return vocabularyTopicResponse;
    }
}

