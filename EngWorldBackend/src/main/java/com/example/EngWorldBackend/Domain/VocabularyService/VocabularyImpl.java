package com.example.EngWorldBackend.Domain.VocabularyService;

import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import com.example.EngWorldBackend.Persistence.DAO.VocabularyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VocabularyImpl implements VocabularyService {

    private final VocabularyRepository vocabRepository;

    @Override
    public Optional<Vocabulary> getVocabById(Long id) {
        return vocabRepository.findById(id);
    }

    @Override
    public List<Vocabulary> getAllVocab() {
        return vocabRepository.findAll();
    }

    @Override
    public void deleteVocabById(Long id) {
        if (vocabRepository.existsById(id)) {
            vocabRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Vocabulary with ID: " + id + " does not exist");
        }
    }

    @Override
    public Vocabulary updateVocabById(Long id, Vocabulary newVocab) {
        return vocabRepository.findById(id)
                .map(existingVocabulary -> {
                    existingVocabulary.setVocabWord(newVocab.getVocabWord());
                    existingVocabulary.setVocabMeaning(newVocab.getVocabMeaning());
                    existingVocabulary.setVocabIPA(newVocab.getVocabIPA());
                    existingVocabulary.setVocabExample(newVocab.getVocabExample());
                    existingVocabulary.setTopic(newVocab.getTopic());
                    return vocabRepository.save(existingVocabulary);
                })
                .orElseThrow(() -> new IllegalStateException("Vocabulary with ID: " + id + " does not exist"));
    }

    @Override
    public List<Vocabulary> getAllVocabByTopic(Long topicId) {
        return vocabRepository.findAllByTopic(topicId);
    }
}
