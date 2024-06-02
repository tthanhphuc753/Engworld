package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.VocabularyTopicDto;
import com.example.EngWorldBackend.Domain.Model.Vocab.VocabularyTopic;

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
}

