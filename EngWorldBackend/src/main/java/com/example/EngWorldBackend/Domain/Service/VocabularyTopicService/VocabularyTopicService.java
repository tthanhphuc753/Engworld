package com.example.EngWorldBackend.Domain.Service.VocabularyTopicService;

import com.example.EngWorldBackend.Domain.Model.Vocab.VocabularyTopic;

import java.util.List;
import java.util.Optional;

public interface VocabularyTopicService {
    VocabularyTopic createVocabularyTopic(VocabularyTopic newVocabTopic);

    Optional<VocabularyTopic> getVocabularyTopicById(Long id);

    List<VocabularyTopic> getAllVocabularyTopic();

    void deleteVocabularyTopicById(Long id);

    VocabularyTopic updateVocabularyTopicById(Long id, VocabularyTopic newVocabTopic);
}
