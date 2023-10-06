package com.example.dp_spring_backend.repository;

import com.example.dp_spring_backend.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.inject.Named;

@Named
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
