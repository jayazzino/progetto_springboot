package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping(path = "api/v1/student")
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
