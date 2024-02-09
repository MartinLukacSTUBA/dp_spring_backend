package com.example.dp_spring_backend.mapper;

import com.example.dp_spring_backend.domain.DTO.CarBasicInfoDTO;
import com.example.dp_spring_backend.domain.DTO.input.CreateCarInputDTO;
import com.example.dp_spring_backend.domain.entity.CarEntity;
import com.example.dp_spring_backend.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CarEntityMapper {

    @Autowired
    protected UserRepository userRepository;

    @Mappings({
            @Mapping(target = "currentUser", expression = "java(userRepository.findById(inputDTO.getUserId()))"),
            @Mapping(target = "carTypeEnum",expression = "java(inputDTO.getCarTypeEnum().toString())")
    })
    public abstract CarEntity toCarEntity(CreateCarInputDTO inputDTO);

    public abstract CarBasicInfoDTO toBasicInfoDTO(CarEntity carEntity);
}
