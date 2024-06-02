package com.example.EngWorldBackend.DTO;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary}
 */
@Data
public class VocabularyDto implements Serializable {
    Long vocabId;
    String vocabWord;
    String vocabMeaning;
    String vocabIPA;
    String vocabExample;
}