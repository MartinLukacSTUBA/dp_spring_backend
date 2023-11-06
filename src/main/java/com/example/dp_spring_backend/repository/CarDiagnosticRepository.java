package com.example.dp_spring_backend.repository;

import com.example.dp_spring_backend.domain.entity.CarDiagnosticEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarDiagnosticRepository extends JpaRepository<CarDiagnosticEntity,Integer> {
    List<CarDiagnosticEntity> findByRecorderId_Id(Long id);
}
