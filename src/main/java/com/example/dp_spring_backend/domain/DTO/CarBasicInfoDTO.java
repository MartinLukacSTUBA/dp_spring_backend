package com.example.dp_spring_backend.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarBasicInfoDTO {

    private Long id;
    private String name;
    private String vehicleNumberPlate;
    private Boolean owned;

}
