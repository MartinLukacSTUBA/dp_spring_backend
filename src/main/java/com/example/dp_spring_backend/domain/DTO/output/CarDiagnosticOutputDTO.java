package com.example.dp_spring_backend.domain.DTO.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class CarDiagnosticOutputDTO {

    private Long id;
    private String lastname;
    private String carName;
    private Long averageSpeed;
    private Long averageRpm;
    private Long averageEngineTemperature;
    private Long averageThrottlePosition;
    private Long averageEngineLoad;
    private Long averageFuelPressure;
    private String startAddress;
    private String startLatitude;
    private String startLongitude;
    private String endAddress;
    private String endLatitude;
    private String endLongitude;
}
