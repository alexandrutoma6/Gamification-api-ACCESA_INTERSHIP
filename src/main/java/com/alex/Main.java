package com.alex;

import com.alex.model.entity.AccountUser;
import com.alex.model.entity.Assignment;
import com.alex.model.entity.Quest;
import com.alex.repository.AccountUserRepository;
import com.alex.repository.AssignmentRepository;
import com.alex.repository.QuestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.spel.ast.Assign;

@SpringBootApplication
public class Main {
    private final AccountUserRepository accountUserRepository;

    public Main(AccountUserRepository accountUserRepository) {
        this.accountUserRepository = accountUserRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Bean
    CommandLineRunner atStartup(AccountUserRepository userRepository) {
        return args -> {
            userRepository.save(new AccountUser("Alex", 200));
        };
    }
    CommandLineRunner atStartup(QuestRepository questRepository) {
        return args -> {
            questRepository.save(new Quest("Open Tv", 10));
        };
    }
    /*
    CommandLineRunner atStartup(AssignmentRepository assignmentRepository) {
        return args -> {
            assignmentRepository.save(new Assignment("1",1,"In progress"));
        };
    }
    */
}
