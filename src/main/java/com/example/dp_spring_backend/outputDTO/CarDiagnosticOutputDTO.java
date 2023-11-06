package com.example.dp_spring_backend.outputDTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDiagnosticOutputDTO {

    private String data1;
    private String data2;
    private Long recorderId;
    private LocalDateTime diagnosticTimeDate;

}
