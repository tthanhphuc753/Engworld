package com.example.EngWorldBackend.Domain.Service.GrammarService;

import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface GrammarService {
    Grammar createGrammar(Grammar newGrammar);

    Optional<Grammar> getGrammarById(Long id);

    Page<Grammar> getAllGrammar(int pageNumber, int pageSize);

    void deleteGrammarById(Long id);

    Grammar updateGrammarById(Long id, Grammar newGrammar) throws Exception;

    Page<Grammar> getAllGrammarByType(Long grammarTypeId, int pageNumber, int pageSize);
}
