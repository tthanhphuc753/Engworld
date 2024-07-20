package com.example.EngWorldBackend;

import com.example.EngWorldBackend.Domain.Model.User.User;
import com.example.EngWorldBackend.Domain.Security.ApplicationConfig;
import com.example.EngWorldBackend.Persistence.DAO.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class EngWorldBackendApplication {
    @Autowired
    private ApplicationConfig applicationConfig;




    public static void main(String[] args) {
        SpringApplication.run(EngWorldBackendApplication.class, args);
    }

    //@Autowired


//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository userRepository) {
//        return args -> {
//            User Phuc = new User(null, "Phuc", "Tran"
//                    , "tthanhphuc753@gmail.com"
//                    , applicationConfig.passwordEncoder().encode("123456")
//                    , "ADMIN", null, true);
//            userRepository.save(Phuc);
//
//
//        };
//    }
}
