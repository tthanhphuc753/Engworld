package com.example.EngWorldBackend.Domain.Service.VocabularyTopicService;

import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import com.example.EngWorldBackend.Domain.Model.Vocab.VocabularyTopic;
import com.example.EngWorldBackend.Persistence.DAO.VocabularyTopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
@RequiredArgsConstructor
public class VocabularyTopicServiceImpl implements VocabularyTopicService{

    private final VocabularyTopicRepository vocabTopicRepository;


    @Override
    public VocabularyTopic createVocabularyTopic(VocabularyTopic newVocabTopic) {
        return vocabTopicRepository.save(newVocabTopic);
    }
    @Override
    public Optional<VocabularyTopic> getVocabularyTopicById(Long id) {
        return vocabTopicRepository.findById(id);
    }

    @Override
    public Page<VocabularyTopic> getAllVocabularyTopic(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return vocabTopicRepository.findAll(pageable);
    }

    @Override
    public void deleteVocabularyTopicById(Long id) {
        if (vocabTopicRepository.existsById(id)) {
            vocabTopicRepository.deleteById(id);
        } else {
            throw new IllegalStateException("VocabularyTopic with ID: " + id + " does not exist");
        }
    }

    @Override
    public VocabularyTopic updateVocabularyTopicById(Long id, VocabularyTopic newVocabTopic) {
        return vocabTopicRepository.findById(id)
                .map(existingVocabulary -> {
                    existingVocabulary.setTopicName(newVocabTopic.getTopicName());
                    return vocabTopicRepository.save(existingVocabulary);
                })
                .orElseThrow(() -> new IllegalStateException("Vocabulary with ID: " + id + " does not exist"));
    }


}
