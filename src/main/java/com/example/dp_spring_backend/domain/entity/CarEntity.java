package com.example.dp_spring_backend.domain.entity;

import com.example.dp_spring_backend.enums.FuelEnum;
import com.example.dp_spring_backend.enums.TransmittionTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "vim")
    private String vim;

    @Column(name = "name")
    private String name;

    @Column(name="car_type_enum")
    private String carTypeEnum;

    @Column(name="transsmition")
    private TransmittionTypeEnum transmittionTypeEnum;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User currentUser;

    
    @Column(name = "vehicle_number_plate")
    private String vehicleNumberPlate;

    @CreatedDate
    @Column(name="registration")
    private LocalDate registration;

    @Column(name="registration_expiration")
    private LocalDate registration_expiration;

    @Column(name="last_service")
    private LocalDate lastService;

    @Column(name = "fuel")
    private FuelEnum fuel;

    @Column(name="note")
    private String note;

}
