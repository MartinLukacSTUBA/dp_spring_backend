package com.example.dp_spring_backend.repository;

import com.example.dp_spring_backend.domain.entity.CarDiagnosticEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarDiagnosticRepository extends JpaRepository<CarDiagnosticEntity,Integer> {
    @Query("""
        select c from CarDiagnosticEntity c
        where c.recorderId.id = ?1
        order by c.recorderId.lastname, c.diagnosticTimeDate, c.startAddress""")
    List<CarDiagnosticEntity> findByRecorderId_IdOrderByRecorderId_LastnameAscDiagnosticTimeDateAscStartAddressAsc(Long id);
    @Query("""
        select c from CarDiagnosticEntity c
        order by c.recorderId.lastname, c.diagnosticTimeDate""")
    List<CarDiagnosticEntity> findAll_OrderByRecorderId_LastnameAscDiagnosticTimeDateAsc();
    @Query("select c from CarDiagnosticEntity c order by c.recorderId.lastname")
    List<CarDiagnosticEntity> findByOrderByRecorderId_LastnameAsc();
    List<CarDiagnosticEntity> findByRecorderId_Id(Long id);

    @Override
    Optional<CarDiagnosticEntity> findById(Integer integer);

}
