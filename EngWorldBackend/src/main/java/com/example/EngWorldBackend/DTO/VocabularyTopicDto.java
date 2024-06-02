package com.example.EngWorldBackend.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.EngWorldBackend.Domain.Model.Vocab.VocabularyTopic}
 */
@Data
public class VocabularyTopicDto implements Serializable {
    Long vocabTopicId;
    String topicName;
}