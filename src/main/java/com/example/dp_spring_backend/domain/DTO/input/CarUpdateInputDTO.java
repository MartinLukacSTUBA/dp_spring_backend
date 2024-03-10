package com.example.dp_spring_backend.domain.DTO.input;

import com.example.dp_spring_backend.enums.FuelEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class CarUpdateInputDTO {

        private String name;
        private String transmittionTypeEnum;
        private Long userId;
        private String vehicleNumberPlate;
        private LocalDate registration_expiration;
        private LocalDate lastService;
        private FuelEnum fuel;
        private String note;

    }