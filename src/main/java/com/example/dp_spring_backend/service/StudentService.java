package com.example.dp_spring_backend.service;

import com.example.dp_spring_backend.domain.entity.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudent() {
        return List.of(
                new Student(
                        1L,
                        "jozo",
                        "jozo",
                        LocalDate.now(),
                        12
                )
        );
    }
}
