package com.example.dp_spring_backend.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car_diagnostic")
public class CarDiagnosticEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "data1")
    private String data1;
    @Column(name = "data2")
    private String data2;
    @Column(name="diagnostic_time_date")
    private LocalDateTime diagnosticTimeDate;
    @ManyToOne
    @JoinColumn(name = "recorder_id", referencedColumnName = "id", nullable = false)
    private User recorderId; // Represents the foreign key relationship
}
