package com.example.dp_spring_backend.domain.entity;

import com.example.dp_spring_backend.enums.FuelEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name = "vehicle_number_plate")
    private String vehicleNumberPlate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User currentUser;
    @Column(name = "consuption")
    private Long consuption;
    @Column(name = "fuel")
    private FuelEnum fuel;
    @Column(name = "company_car")
    private boolean companyCar;

}
