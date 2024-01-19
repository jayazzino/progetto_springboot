package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student miriam = new Student(
                    "Miriam",
                    "miriam.caci@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 21),
                    21);

            Student andrea = new Student(
                    "Andrea",
                    "andrea@gmail.com",
                    LocalDate.of(1998, Month.JANUARY, 21),
                    21);
            repository.saveAll(
                    List.of(miriam, andrea));
        };
    }
}
