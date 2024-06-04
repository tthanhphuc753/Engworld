package com.example.EngWorldBackend.Domain.Service.GrammarTypeService;

import com.example.EngWorldBackend.Domain.Model.Grammar.GrammarType;

import java.util.List;
import java.util.Optional;

public interface GrammarTypeService {
    GrammarType createGrammarType(GrammarType grammarType);

    List<GrammarType> getAllGrammarTypes();

    Optional<GrammarType> getGrammarTypeById(Long grammarTypeId);


    GrammarType updateGrammarType(Long id, GrammarType updatedGrammarType);

    void deleteGrammarType(Long grammarTypeId);
}
