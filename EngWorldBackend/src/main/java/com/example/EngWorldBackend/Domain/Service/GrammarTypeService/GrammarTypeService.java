package com.example.EngWorldBackend.Domain.Service.GrammarTypeService;

import com.example.EngWorldBackend.Domain.Model.Grammar.GrammarType;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface GrammarTypeService {
    GrammarType createGrammarType(GrammarType grammarType);

    Page<GrammarType> getAllGrammarTypes(int pageNumber, int pageSize);

    Optional<GrammarType> getGrammarTypeById(Long grammarTypeId);


    GrammarType updateGrammarType(Long id, GrammarType updatedGrammarType);

    void deleteGrammarType(Long grammarTypeId);
}
