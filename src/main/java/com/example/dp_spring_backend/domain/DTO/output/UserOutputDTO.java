package com.example.dp_spring_backend.domain.DTO.output;

import com.example.dp_spring_backend.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserOutputDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private RoleEnum role;
    private String address;
    private String phoneNumber;
    private String position;
    private String drivingLicense;

}
