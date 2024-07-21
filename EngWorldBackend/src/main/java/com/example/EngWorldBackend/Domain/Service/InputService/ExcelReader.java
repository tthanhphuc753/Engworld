package com.example.EngWorldBackend.Domain.Service.InputService;

import com.example.EngWorldBackend.Domain.Model.Exercise;
import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
import com.example.EngWorldBackend.Domain.Model.Question;
import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import com.example.EngWorldBackend.Domain.Model.Vocab.VocabularyTopic;
import com.example.EngWorldBackend.Persistence.DAO.ExerciseRepository;
import com.example.EngWorldBackend.Persistence.DAO.GrammarRepository;
import com.example.EngWorldBackend.Persistence.DAO.VocabularyRepository;
import com.example.EngWorldBackend.Persistence.DAO.VocabularyTopicRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Component
public class ExcelReader {

    public List<Question> readQuestionFromExcel(InputStream inputStream,
                                                VocabularyRepository vocabularyRepository,
                                                GrammarRepository grammarRepository,
                                                ExerciseRepository exerciseRepository) throws IOException {
        List<Question> questions = new ArrayList<>();

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
            String questionText = getCellValue(row.getCell(columnMap.get("Text")));
            String correctAnswer = getCellValue(row.getCell(columnMap.get("Answer")));
            String op1 = getCellValue(row.getCell(columnMap.get("Op1")));
            String op2 = getCellValue(row.getCell(columnMap.get("Op2")));
            String op3 = getCellValue(row.getCell(columnMap.get("Op3")));
            Long vocabId = null;
            Long grammarId = null;
            Long exerciseId = null;
            try {
                vocabId = Long.valueOf(getCellValue(row.getCell(columnMap.get("VocabID"))));
                grammarId = Long.valueOf(getCellValue(row.getCell(columnMap.get("GrammarID"))));
                exerciseId = Long.valueOf(getCellValue(row.getCell(columnMap.get("ExerciseID"))));
            } catch (NumberFormatException e) {
                // Handle the case where Id is not a valid Long
                System.err.println("Invalid Id at row " + (i + 1));
                continue; // Skip this row
            }

            // Retrieve the vocabulary, grammar, and exercise
            Long finalVocabId = vocabId;
            int finalI = i;
            Vocabulary vocabulary = vocabularyRepository.findById(vocabId)
                    .orElseThrow(() -> new IllegalStateException("Vocabulary not found for Id " + finalVocabId + " at row " + (finalI + 1)));
            Long finalGrammarId = grammarId;
            int finalI1 = i;
            Grammar grammar = grammarRepository.findById(grammarId)
                    .orElseThrow(() -> new IllegalStateException("Grammar not found for Id " + finalGrammarId + " at row " + (finalI1 + 1)));
            Long finalExerciseId = exerciseId;
            int finalI2 = i;
            Exercise exercise = exerciseRepository.findById(exerciseId)
                    .orElseThrow(() -> new IllegalStateException("Exercise not found for Id " + finalExerciseId + " at row " + (finalI2 + 1)));

            // Create Question object
            Question question = new Question(questionText, correctAnswer, op1, op2, op3, vocabulary, grammar, exercise);
            questions.add(question);
        }

        workbook.close();
        return questions;
    }


    public List<Vocabulary> readVocabFromExcel(InputStream inputStream,
                                               VocabularyTopicRepository vocabTopicRepository) throws IOException {
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
            Vocabulary vocabulary = new Vocabulary(word, meaning, iPA, example, vocabularyTopic);
            vocabularies.add(vocabulary);
        }

        workbook.close();
        return vocabularies;
    }

    public static String getCellValue(Cell cell) {
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
}