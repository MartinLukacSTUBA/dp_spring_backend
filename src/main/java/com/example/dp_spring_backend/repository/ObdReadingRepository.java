package com.example.dp_spring_backend.repository;

import com.example.dp_spring_backend.domain.entity.ObdReading;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ObdReadingRepository extends PagingAndSortingRepository<ObdReading, Long> {

    Page<ObdReading> findAllByVin(String vin, Pageable pageable);

}
