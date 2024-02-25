package com.example.dp_spring_backend.domain.DTO.output;

import com.example.dp_spring_backend.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarOutputForEmailsDTO {

    private User currentUser;
    private String name;
    private LocalDate registration_expiration;

}


