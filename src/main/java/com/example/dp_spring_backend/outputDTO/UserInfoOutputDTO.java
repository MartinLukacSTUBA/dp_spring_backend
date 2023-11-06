package com.example.dp_spring_backend.outputDTO;

import com.example.dp_spring_backend.enums.RoleEnum;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoOutputDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private RoleEnum role;

}
