package com.example.dp_spring_backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "obd_readings")
public class ObdReading implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Version
    private long version;
    private double latitude, longitude;
    private long timestamp;

    @Column(name = "vin", nullable = false)
    private String vin;

    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, String> readings;

}
