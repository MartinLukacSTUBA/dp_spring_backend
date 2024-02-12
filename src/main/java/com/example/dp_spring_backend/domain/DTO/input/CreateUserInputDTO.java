package com.example.dp_spring_backend.domain.DTO.input;

import com.example.dp_spring_backend.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserInputDTO {


    private String firstname;
    private String lastname;
    private String email;
    private RoleEnum role;
    private String address;
    private String phoneNumber;
    private String position;
    private String drivingLicense;

}
