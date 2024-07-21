package com.example.EngWorldBackend.Domain.Service.GrammarService;

import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
import com.example.EngWorldBackend.Domain.Model.Grammar.GrammarType;
import com.example.EngWorldBackend.Persistence.DAO.GrammarRepository;
import com.example.EngWorldBackend.Persistence.DAO.GrammarTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GrammarServiceImpl implements GrammarService {

    private final GrammarRepository grammarRepository;
    private final GrammarTypeRepository grammarTypeRepository;

    @Override
    public Grammar createGrammar(Grammar newGrammar) {
        return grammarRepository.save(newGrammar);
    }

    @Override
    public Optional<Grammar> getGrammarById(Long id) {
        return grammarRepository.findById(id);
    }

    @Override
    public Page<Grammar> getAllGrammar(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return grammarRepository.findAll(pageable);
    }

    @Override
    public void deleteGrammarById(Long id) {
        try {
            grammarRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new GrammarNotFoundException("Grammar with ID: " + id + " does not exist");
        }
    }

    @Override
    public Grammar updateGrammarById(Long id, Grammar newGrammar) throws GrammarNotFoundException {
        Optional<Grammar> grammarOptional = grammarRepository.findById(id);
        if (grammarOptional.isPresent()) {
            Grammar existingGrammar = grammarOptional.get();
            existingGrammar.setGrammarTitle(newGrammar.getGrammarTitle());
            existingGrammar.setGrammarDes(newGrammar.getGrammarDes());
            existingGrammar.setGrammarExample(newGrammar.getGrammarExample());
            existingGrammar.setGrammarType(addTypeToGrammar(newGrammar.getGrammarType()));
            return grammarRepository.save(existingGrammar);
        } else {
            throw new GrammarNotFoundException("Grammar not found with id: " + id);
        }
    }

    @Override
    public Page<Grammar> getAllGrammarByType(Long grammarTypeId, int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        GrammarType grammarType = grammarTypeRepository.findById(grammarTypeId)
                .orElseThrow(() -> new GrammarTypeNotFoundException("GrammarType not found with id: " + grammarTypeId));
        return grammarRepository.findByGrammarType(grammarType,pageable);
    }

    private GrammarType addTypeToGrammar(GrammarType grammarType) {
        return grammarTypeRepository.findById(grammarType.getGrammarTypeId())
                .orElseThrow(() -> new GrammarTypeNotFoundException("GrammarType not found with id: " + grammarType.getGrammarTypeId()));
    }

    private static class GrammarNotFoundException extends RuntimeException {
        public GrammarNotFoundException(String message) {
            super(message);
        }
    }

    private static class GrammarTypeNotFoundException extends RuntimeException {
        public GrammarTypeNotFoundException(String message) {
            super(message);
        }
    }


}