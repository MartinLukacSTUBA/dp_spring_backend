package com.example.dp_spring_backend.mapper;

import com.example.dp_spring_backend.domain.DTO.UserBasicInfoDTO;
import com.example.dp_spring_backend.domain.DTO.input.CreateUserInputDTO;
import com.example.dp_spring_backend.domain.DTO.output.UserOutputDTO;
import com.example.dp_spring_backend.domain.entity.User;
import com.example.dp_spring_backend.outputDTO.UserInfoOutputDTO;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {

    public abstract UserInfoOutputDTO toUserInfoOutputDTO(User user);

    public abstract User createUserToUser(CreateUserInputDTO inputDTO);

    public abstract UserBasicInfoDTO toBasicInfoDTO(User user);

    public abstract List<UserBasicInfoDTO> toListBasicInfoDTO(List<User> users);

    public abstract UserOutputDTO toUserOutputDTO(User user);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "firstname", source = "inputDTO.firstname", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
        @Mapping(target = "lastname", source = "inputDTO.lastname", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
        @Mapping(target = "email", source = "inputDTO.email", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
        @Mapping(target = "role", source = "inputDTO.role", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
        @Mapping(target = "address", source = "inputDTO.address", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
        @Mapping(target = "phoneNumber", source = "inputDTO.phoneNumber", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
        @Mapping(target = "position", source = "inputDTO.position", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
        @Mapping(target = "drivingLicense", source = "inputDTO.drivingLicense", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    })
    public abstract void createDTOToEntity(@MappingTarget User user, CreateUserInputDTO inputDTO);


}
