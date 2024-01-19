package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Andrea",
                        "andrea@gmail.com",
                        LocalDate.of(1998, Month.MARCH, 21),
                        21));
    }
}
