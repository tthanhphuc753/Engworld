package com.example.EngWorldBackend.Domain.Service.VocabularyService;

import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import com.example.EngWorldBackend.Domain.Model.Vocab.VocabularyTopic;
import com.example.EngWorldBackend.Persistence.DAO.VocabularyRepository;
import com.example.EngWorldBackend.Persistence.DAO.VocabularyTopicRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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
    public Page<Vocabulary> getAllVocab(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return vocabRepository.findAll(pageable);
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
    public Page<Vocabulary> getAllVocabByTopic(Long topicId, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        VocabularyTopic vocabularyTopic = vocabTopicRepository.findById(topicId)
                .orElseThrow(() -> new VocabularyTopicNotFoundException("VocabTopic not found with id: " + topicId));
        return vocabRepository.findByTopic(vocabularyTopic, pageable);
    }

    @Override
    public Vocabulary findByWord(String vocabWord) {
        return vocabRepository.findByVocabWord(vocabWord);
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


    public List<Vocabulary> readVocabFromExcel(InputStream inputStream) throws IOException {
        List<Vocabulary> vocabularies = new ArrayList<>();

        // Create Workbook instance for the Excel file
        Workbook workbook = new XSSFWorkbook(inputStream);

        // Get a reference to the first sheet
        Sheet sheet = workbook.getSheetAt(0);

        // Map column names to column indices
        Map<String, Integer> columnMap = new HashMap<>();
        Row headerRow = sheet.getRow(0);
        for (Cell cell : headerRow) {
            String columnName = cell.getStringCellValue().trim();
            columnMap.put(columnName, cell.getColumnIndex());
        }

        // Iterate through the rows in the sheet
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            // Get data from cells in the row based on column names
            String word = getCellValue(row.getCell(columnMap.get("Word")));
            String meaning = getCellValue(row.getCell(columnMap.get("Mean")));
            String example = getCellValue(row.getCell(columnMap.get("Example")));
            String iPA = getCellValue(row.getCell(columnMap.get("IPA")));
            Long topicId = null;
            try {
                topicId = Long.valueOf(getCellValue(row.getCell(columnMap.get("TopicId"))));
            } catch (NumberFormatException e) {
                // Handle the case where TopicId is not a valid Long
                System.err.println("Invalid TopicId at row " + (i + 1));
                continue; // Skip this row
            }

            // Retrieve the vocabulary topic
            Optional<VocabularyTopic> optionalVocabularyTopic = vocabTopicRepository.findById(topicId);
            if (!optionalVocabularyTopic.isPresent()) {
                System.err.println("VocabularyTopic not found for TopicId " + topicId + " at row " + (i + 1));
                continue; // Skip this row
            }
            VocabularyTopic vocabularyTopic = optionalVocabularyTopic.get();

            // Create Vocabulary object
            Vocabulary vocabulary = new Vocabulary(word, meaning, iPA, example, addTopicToVocab(vocabularyTopic));
            vocabularies.add(vocabulary);
        }

        workbook.close();
        return vocabularies;
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return Double.toString(cell.getNumericCellValue()).replace(".0", ""); // Remove trailing .0 if it's an integer
                }
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            default:
                return "";
        }
    }


    @Override
    public void addVocabFromExcel(InputStream inputStream) throws IOException {
        List<Vocabulary> vocabularies = readVocabFromExcel(inputStream);
        vocabRepository.saveAll(vocabularies);
    }


}
