package com.example.EngWorldBackend;

import com.example.EngWorldBackend.Domain.Model.Exercise;
import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
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
//    CommandLineRunner commandLineRunner(QuestionRepository questionRepository, ExerciseRepository exerciseRepository, GrammarRepository grammarRepository) {
//        return args -> {
//            Exercise exercise = exerciseRepository.findById(2L)
//                    .orElseThrow(() -> new RuntimeException("Exercise not found"));
//
//            Grammar grammar = grammarRepository.findById(1L) // Assuming grammar ID for "Present Simple" is 1
//                    .orElseThrow(() -> new RuntimeException("Grammar not found"));
//
//            List<Question> questions = new ArrayList<>();
//
//            questions.add(createGrammarQuestion("My brother ........ in the same company for five years now.", "works", "work", "working", "worked", exercise, grammar));
//            questions.add(createGrammarQuestion("They ........ the house every Saturday morning.", "clean", "cleans", "cleaning", "cleaned", exercise, grammar));
//            questions.add(createGrammarQuestion("Water ........ at 100 degrees Celsius.", "boils", "boil", "boiling", "boiled", exercise, grammar));
//            questions.add(createGrammarQuestion("She ........ as a doctor in a local hospital.", "works", "work", "working", "worked", exercise, grammar));
//            questions.add(createGrammarQuestion("Tom and Jerry ........ to school by bus every day.", "go", "goes", "going", "gone", exercise, grammar));
//            questions.add(createGrammarQuestion("The store ........ at 9 PM every day.", "closes", "close", "closing", "closed", exercise, grammar));
//            questions.add(createGrammarQuestion("She ........ to the gym three times a week.", "goes", "go", "going", "gone", exercise, grammar));
//            questions.add(createGrammarQuestion("My parents ........ in a small town near the coast.", "live", "lives", "living", "lived", exercise, grammar));
//            questions.add(createGrammarQuestion("He ........ breakfast before going to work.", "eats", "eat", "eating", "ate", exercise, grammar));
//            questions.add(createGrammarQuestion("Our team usually ........ the project on time.", "finishes", "finish", "finishing", "finished", exercise, grammar));
//
//            questionRepository.saveAll(questions);
//        };
//    }

    private Question createGrammarQuestion(String questionText, String correctAnswer, String option1, String option2, String option3, Exercise exercise, Grammar grammar) {
        return Question.builder()
                .questionText(questionText)
                .correctAnswer(correctAnswer)
                .op1(option1)
                .op2(option2)
                .op3(option3)
                .grammar(grammar)
                .exercise(exercise)
                .build();
    }


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
