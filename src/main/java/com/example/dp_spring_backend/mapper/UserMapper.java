package com.example.dp_spring_backend.mapper;

import com.example.dp_spring_backend.domain.entity.User;
import com.example.dp_spring_backend.outputDTO.UserInfoOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {

    public abstract UserInfoOutputDTO toUserInfoOutputDTO(User user);
}
