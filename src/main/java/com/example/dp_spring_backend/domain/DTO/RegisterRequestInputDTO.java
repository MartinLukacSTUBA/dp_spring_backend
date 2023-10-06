package com.example.dp_spring_backend.domain.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestInputDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
