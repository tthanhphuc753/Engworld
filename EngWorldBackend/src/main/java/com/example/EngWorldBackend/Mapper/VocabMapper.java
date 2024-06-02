package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.VocabularyDto;
import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;

public class VocabMapper {
    public static VocabularyDto toDTO(Vocabulary vocabulary) {
        VocabularyDto dto = new VocabularyDto();
        dto.setVocabId(vocabulary.getVocabId());
        dto.setVocabWord(vocabulary.getVocabWord());
        dto.setVocabMeaning(vocabulary.getVocabMeaning());
        dto.setVocabIPA(vocabulary.getVocabIPA());
        dto.setVocabExample(vocabulary.getVocabExample());
        return dto;
    }

    public static Vocabulary toEntity(VocabularyDto dto) {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setVocabId(dto.getVocabId());
        vocabulary.setVocabWord(dto.getVocabWord());
        vocabulary.setVocabMeaning(dto.getVocabMeaning());
        vocabulary.setVocabIPA(dto.getVocabIPA());
        vocabulary.setVocabExample(dto.getVocabExample());
        return vocabulary;
    }
}

