package com.example.EngWorldBackend;

import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
import com.example.EngWorldBackend.Domain.Model.Grammar.GrammarType;
import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import com.example.EngWorldBackend.Domain.Model.Vocab.VocabularyTopic;
import com.example.EngWorldBackend.Domain.Security.ApplicationConfig;
import com.example.EngWorldBackend.Persistence.DAO.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

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


    public static void main(String[] args) {
        SpringApplication.run(EngWorldBackendApplication.class, args);
    }

    @Autowired
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {

//            Optional<VocabularyTopic> optionalTopic = topicRepository.findById(10L);
//            if (!optionalTopic.isPresent()) {
//                System.out.println("Không tìm thấy chủ đề với ID là 8.");
//                return;
//            }
//            VocabularyTopic topic = optionalTopic.get();
//
//            // Danh sách các từ vựng về nghề nghiệp
//            Map<String, String[]> fashionVocab = new HashMap<>();
//
//
//            List<Map.Entry<String, String[]>> randomVocab = getRandomElements(new ArrayList<>(fashionVocab.entrySet()), 20);
//
//            // Tạo và thêm từ vựng vào cơ sở dữ liệu
//            for (Map.Entry<String, String[]> entry : randomVocab) {
//                String word = entry.getKey();
//                String[] data = entry.getValue();
//
//                Vocabulary newVocab = Vocabulary.builder()
//                        .vocabWord(word)
//                        .vocabMeaning(data[0])
//                        .vocabIPA(data[1])
//                        .vocabExample(data[2])
//                        .topic(topic)
//                        .build();
//                vocabrepository.save(newVocab);
//            }
//
//            System.out.println("Thêm 30 từ vựng về nghề nghiệp thành công!");
        };
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
}
