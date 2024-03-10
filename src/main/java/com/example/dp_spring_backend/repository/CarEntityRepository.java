package com.example.dp_spring_backend.repository;

import com.example.dp_spring_backend.domain.entity.CarEntity;
import com.example.dp_spring_backend.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarEntityRepository extends JpaRepository<CarEntity, Long> {
    List<CarEntity> findByCurrentUser(User currentUser);


    List<CarEntity> findAllByOrderByIdAsc();

    @Query(value = "SELECT * " +
        "FROM car " +
        "WHERE registration_expiration > CURRENT_DATE " +
        "AND registration_expiration <= CURRENT_DATE + INTERVAL '3 months'", nativeQuery = true)
    List<CarEntity> selectAllOldData();
}