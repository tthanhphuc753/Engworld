package com.example.EngWorldBackend;

import com.example.EngWorldBackend.Domain.Model.Question;
import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import com.example.EngWorldBackend.Domain.Security.ApplicationConfig;
import com.example.EngWorldBackend.Persistence.DAO.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@SpringBootApplication
public class EngWorldBackendApplication {
    @Autowired
    private ApplicationConfig applicationConfig;
    @Autowired
    private VocabularyTopicRepository topicRepository;
    @Autowired
    private VocabularyRepository vocabrepository;
    @Autowired
    private GrammarTypeRepository grammarTypeRepository;
    @Autowired
    private GrammarRepository grammarRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private VocabularyRepository vocabularyRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;
    private Random random = new Random();

    public static void main(String[] args) {
        SpringApplication.run(EngWorldBackendApplication.class, args);
    }


// Đối tượng repository cho các đối tượng khác như Vocabulary, Grammar, Exercise

//    @Bean
//    CommandLineRunner commandLineRunner() {
//        return args -> {
//            List<Question> questions = questionRepository.findAll();
//
//            // Lặp qua từng câu hỏi và cập nhật cột vocab_id
//            for (Question question : questions) {
//                // Lấy từ vựng tương ứng cho câu hỏi, ví dụ:
//                Vocabulary vocabulary = vocabularyRepository.findByVocabWord(question.getCorrectAnswer());
//                // Nếu tìm thấy từ vựng, cập nhật cột vocab_id của câu hỏi
//                if (vocabulary != null) {
//                    question.setVocab(vocabulary);
//                    // Lưu thay đổi vào cơ sở dữ liệu
//                    questionRepository.save(question);
//                } else {
//                    // Xử lý trường hợp không tìm thấy từ vựng
//                }
//            }
//        };
//    }


    private <T> List<T> getRandomElements(List<T> originalList, int count) {
        List<T> randomElements = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            T element = originalList.get(random.nextInt(originalList.size()));
            randomElements.add(element);
        }
        return randomElements;
    }

    private String getRandomWord(List<Vocabulary> vocabularies, String excludeWord) {
        if (vocabularies == null || vocabularies.isEmpty()) {
            throw new IllegalArgumentException("Vocabulary list is empty or null");
        }
        String randomWord;
        Random random = new Random();
        do {
            randomWord = vocabularies.get(random.nextInt(vocabularies.size())).getVocabWord();
        } while (randomWord.equals(excludeWord));
        return randomWord;
    }

    private Question createQuestion(String questionText, String correctAnswer, List<Vocabulary> vocabularies) {
        return Question.builder()
                .questionText(questionText)
                .correctAnswer(correctAnswer)
                .op1(getRandomWord(vocabularies, correctAnswer))
                .op2(getRandomWord(vocabularies, correctAnswer))
                .op3(getRandomWord(vocabularies, correctAnswer))
                .vocab(vocabularies.get(0)) // Assuming we can assign any vocabulary to the question
                .grammar(null)
                .exercise(exerciseRepository.findById(1l).get())
                .build();
    }

}
