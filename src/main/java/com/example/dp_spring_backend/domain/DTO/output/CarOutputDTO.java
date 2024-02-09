package com.example.dp_spring_backend.domain.DTO.output;

import com.example.dp_spring_backend.enums.FuelEnum;
import com.example.dp_spring_backend.enums.TransmittionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarOutputDTO {

    private Long id;
    private String vim;
    private String name;
    private String carTypeEnum;
    private TransmittionTypeEnum transmittionTypeEnum;
    private String userName;
    private String vehicleNumberPlate;
    private LocalDate registration;
    private LocalDate registration_expiration;
    private LocalDate lastService;
    private FuelEnum fuel;
    private String note;

}
