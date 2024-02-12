package com.example.dp_spring_backend.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBasicInfoDTO {

    private Long id;
    private String lastname;
    private String drivingLicense;

}
