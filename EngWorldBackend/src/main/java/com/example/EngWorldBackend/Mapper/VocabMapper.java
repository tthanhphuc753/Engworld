package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.VocabularyDto;
import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import com.example.EngWorldBackend.Domain.Model.Vocab.VocabularyTopic;
import com.example.EngWorldBackend.Persistence.DAO.VocabularyTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VocabMapper {

    @Autowired
    private VocabularyTopicRepository vocabularyTopicRepository;

    public VocabularyDto toDTO(Vocabulary vocabulary) {
        if (vocabulary == null) {
            return null;
        }
        VocabularyDto dto = new VocabularyDto();
        dto.setVocabId(vocabulary.getVocabId());
        dto.setVocabWord(vocabulary.getVocabWord());
        dto.setVocabMeaning(vocabulary.getVocabMeaning());
        dto.setVocabIPA(vocabulary.getVocabIPA());
        dto.setVocabExample(vocabulary.getVocabExample());

        if (vocabulary.getTopic() != null) {
            vocabularyTopicRepository.findById(vocabulary
                    .getTopic()
                    .getVocabTopicId())
                    .ifPresent(topic -> dto.setTopicName(topic.getTopicName()));
        }

        return dto;
    }

    public Vocabulary toEntity(VocabularyDto dto) {
        if (dto == null) {
            return null;
        }
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setVocabId(dto.getVocabId());
        vocabulary.setVocabWord(dto.getVocabWord());
        vocabulary.setVocabMeaning(dto.getVocabMeaning());
        vocabulary.setVocabIPA(dto.getVocabIPA());
        vocabulary.setVocabExample(dto.getVocabExample());

        if (dto.getTopicName() != null) {
            VocabularyTopic topic = vocabularyTopicRepository.findByTopicName(dto.getTopicName());
            vocabulary.setTopic(topic);
        }
        return vocabulary;
    }
}
