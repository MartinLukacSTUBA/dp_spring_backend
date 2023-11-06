package com.example.dp_spring_backend.repository;

import com.example.dp_spring_backend.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    User findById(Long id);

}
