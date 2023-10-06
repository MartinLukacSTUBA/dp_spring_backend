package com.example.dp_spring_backend;

import com.example.dp_spring_backend.domain.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class DpSpringBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(DpSpringBackendApplication.class, args);
    }
}