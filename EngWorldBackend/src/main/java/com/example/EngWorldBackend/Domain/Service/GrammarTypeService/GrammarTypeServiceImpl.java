package com.example.EngWorldBackend.Domain.Service.GrammarTypeService;

import com.example.EngWorldBackend.Domain.Model.Grammar.GrammarType;
import com.example.EngWorldBackend.Persistence.DAO.GrammarTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class GrammarTypeServiceImpl implements GrammarTypeService{

    private final GrammarTypeRepository grammarTypeRepository;

    @Override
    public GrammarType createGrammarType(GrammarType grammarType) {
        return grammarTypeRepository.save(grammarType);
    }

    @Override
    public Page<GrammarType> getAllGrammarTypes(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return grammarTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<GrammarType> getGrammarTypeById(Long grammarTypeId) {
        return grammarTypeRepository.findById(grammarTypeId);
    }

    @Override
    public GrammarType updateGrammarType(Long id,GrammarType updatedGrammarType) {
        Optional<GrammarType> optionalGrammarType = grammarTypeRepository.findById(updatedGrammarType.getGrammarTypeId());
        if (optionalGrammarType.isPresent()) {
            GrammarType existingGrammarType = optionalGrammarType.get();
            existingGrammarType.setTypeName(updatedGrammarType.getTypeName());
            existingGrammarType.setTypeDes(updatedGrammarType.getTypeDes());
            return grammarTypeRepository.save(existingGrammarType);
        } else {
            throw new RuntimeException("GrammarType not found with id: " + updatedGrammarType.getGrammarTypeId());
        }
    }

    @Override
    public void deleteGrammarType(Long grammarTypeId) {
        grammarTypeRepository.deleteById(grammarTypeId);
    }
}
