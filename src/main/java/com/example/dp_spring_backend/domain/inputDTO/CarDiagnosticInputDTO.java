package com.example.dp_spring_backend.domain.inputDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CarDiagnosticInputDTO {

    private String data1;
    private String data2;
    private Long recorderId;
    private LocalDateTime diagnosticTimeDate;

}
