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

    @Column(name = "average_speed")
    private Long averageSpeed;

    @Column(name = "average_rpm")
    private Long averageRpm;

    @Column(name = "average_engine_temperature")
    private Long averageEngineTemperature;

    @Column(name = "average_throttle_position")
    private Long averageThrottlePosition;

    @Column(name = "average_engine_load")
    private Long averageEngineLoad;

    @Column(name = "average_fuel_pressure")
    private Long averageFuelPressure;

    @Column(name="diagnostic_time_date")
    private LocalDateTime diagnosticTimeDate;

    @ManyToOne
    @JoinColumn(name = "recorder_id", referencedColumnName = "id", nullable = false)
    private User recorderId; // Represents the foreign key relationship
}
