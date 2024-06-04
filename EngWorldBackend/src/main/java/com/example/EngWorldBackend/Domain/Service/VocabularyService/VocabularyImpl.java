package com.example.EngWorldBackend.Domain.Service.VocabularyService;

import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import com.example.EngWorldBackend.Domain.Model.Vocab.VocabularyTopic;
import com.example.EngWorldBackend.Persistence.DAO.VocabularyRepository;
import com.example.EngWorldBackend.Persistence.DAO.VocabularyTopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class VocabularyImpl implements VocabularyService {

    private final VocabularyRepository vocabRepository;
    private final VocabularyTopicRepository vocabTopicRepository;

    @Override
    public Vocabulary createVocab(Vocabulary newVocab) {
        return vocabRepository.save(newVocab);
    }

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
        try {
            vocabRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new VocabularyNotFoundException("Vocabulary with ID: " + id + " does not exist");
        }
    }

    @Override
    public Vocabulary updateVocabById(Long id, Vocabulary newVocab) throws VocabularyNotFoundException {
        Optional<Vocabulary> vocabOptional = vocabRepository.findById(id);
        if (vocabOptional.isPresent()) {
            Vocabulary existingVocab = vocabOptional.get();
            existingVocab.setVocabWord(newVocab.getVocabWord());
            existingVocab.setVocabExample(newVocab.getVocabExample());
            existingVocab.setVocabMeaning(newVocab.getVocabMeaning());
            existingVocab.setTopic(addTopicToVocab(newVocab.getTopic()));
            return vocabRepository.save(existingVocab);
        } else {
            throw new VocabularyNotFoundException("Vocabulary not found with id: " + id);
        }
    }

    @Override
    public List<Vocabulary> getAllVocabByTopic(Long topicId) {
        return vocabRepository.findAllByTopic(topicId);
    }

    private VocabularyTopic addTopicToVocab(VocabularyTopic vocabTopic) {
        return vocabTopicRepository.findById(vocabTopic.getVocabTopicId())
                .orElseThrow(() -> new VocabularyTopicNotFoundException("VocabularyTopic not found with id: " + vocabTopic.getVocabTopicId()));
    }

    private static class VocabularyNotFoundException extends RuntimeException {
        public VocabularyNotFoundException(String message) {
            super(message);
        }
    }

    private static class VocabularyTopicNotFoundException extends RuntimeException {
        public VocabularyTopicNotFoundException(String message) {
            super(message);
        }
    }
}
