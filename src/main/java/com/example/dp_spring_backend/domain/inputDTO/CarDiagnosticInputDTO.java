package com.example.dp_spring_backend.domain.inputDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CarDiagnosticInputDTO {

    private Long averageSpeed;
    private Long averageRpm;
    private Long averageEngineTemperature;
    private Long averageThrottlePosition;
    private Long averageEngineLoad;
    private Long averageFuelPressure;

}
