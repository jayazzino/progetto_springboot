package com.example.demo.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.el.ELException;
import jakarta.transaction.Transactional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalAccessError("email gia in uso");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if (!exist) {
            throw new IllegalAccessError("utente con Id: " + studentId + " non presente");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional // mi permetterà di effetuare modifiche nel database senza usare QueryS
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalAccessError("studente " + studentId + " non esiste"));

        if (name != null && name.length() > 0 && !student.getName().equals(name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !student.getEmail().equals(email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalAccessError("email già in uso");
            }
            student.setEmail(email);
        }
    }
}
