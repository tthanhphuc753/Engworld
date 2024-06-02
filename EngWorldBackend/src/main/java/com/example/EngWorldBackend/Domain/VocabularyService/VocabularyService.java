package com.example.EngWorldBackend.Domain.VocabularyService;

import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;

import java.util.List;
import java.util.Optional;

public interface VocabularyService {

    public Optional<Vocabulary> getVocabById(Long id);
    public List<Vocabulary> getAllVocab();
    public void deleteVocabById(Long id);
    public Vocabulary updateVocabById(Long id, Vocabulary vocabulary);
    public List<Vocabulary> getAllVocabByTopic(Long topicId);

}
