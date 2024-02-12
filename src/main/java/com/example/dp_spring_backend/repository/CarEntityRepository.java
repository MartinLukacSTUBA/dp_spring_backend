package com.example.dp_spring_backend.repository;

import com.example.dp_spring_backend.domain.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarEntityRepository extends JpaRepository<CarEntity, Long> {


    List<CarEntity> findAllByOrderByIdAsc();
}