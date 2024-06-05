package com.example.EngWorldBackend.Persistence.DAO;

import com.example.EngWorldBackend.Domain.Model.Grammar.GrammarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrammarTypeRepository extends JpaRepository<GrammarType,Long> {
    GrammarType findByTypeName(String grammarType);
}
