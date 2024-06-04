package com.example.EngWorldBackend.Domain.Service.GrammarService;

import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;

import java.util.List;
import java.util.Optional;

public interface GrammarService {
    Grammar createGrammar(Grammar newGrammar);

    Optional<Grammar> getGrammarById(Long id);

    List<Grammar> getAllGrammar();

    void deleteGrammarById(Long id);

    Grammar updateGrammarById(Long id, Grammar newGrammar) throws Exception;

    List<Grammar> getAllGrammarByType(Long grammarTypeId);
}
