package com.example.dp_spring_backend.mapper;

import com.example.dp_spring_backend.domain.DTO.CarBasicInfoDTO;
import com.example.dp_spring_backend.domain.DTO.IdNameDTO;
import com.example.dp_spring_backend.domain.DTO.input.CarUpdateInputDTO;
import com.example.dp_spring_backend.domain.DTO.input.CreateCarInputDTO;
import com.example.dp_spring_backend.domain.DTO.output.CarOutputDTO;
import com.example.dp_spring_backend.domain.DTO.output.CarOutputForEmailsDTO;
import com.example.dp_spring_backend.domain.entity.CarEntity;
import com.example.dp_spring_backend.repository.UserRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public abstract List<CarBasicInfoDTO> toListBasicInfoDTO(List<CarEntity> allCars);

    @Mappings({
        @Mapping(target = "userName",expression = "java(carEntity.getCurrentUser().getLastname())")
    })
    public abstract CarOutputDTO toCarOutputDTO(CarEntity carEntity);



    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "vim", ignore = true),
        @Mapping(target = "name", source = "inputDTO.name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
        @Mapping(target = "transmittionTypeEnum", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
        @Mapping(target = "currentUser", expression = "java(inputDTO.getUserId() != null ? userRepository.findById(inputDTO.getUserId()) : carEntity.getCurrentUser())"),
        @Mapping(target = "vehicleNumberPlate", source = "inputDTO.vehicleNumberPlate", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
        @Mapping(target = "registration", ignore = true),
        @Mapping(target = "registration_expiration", source = "inputDTO.registration_expiration", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
        @Mapping(target = "lastService", source = "inputDTO.lastService", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
        @Mapping(target = "fuel", source = "inputDTO.fuel", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
        @Mapping(target = "note", source = "inputDTO.note", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
    })
    public abstract void inputDTOToEntity(@MappingTarget CarEntity carEntity, CarUpdateInputDTO inputDTO);


    public abstract List<CarOutputForEmailsDTO> carEntityToCarOutputForEmailsDTO(List<CarEntity> carEntities);

    public abstract IdNameDTO idNameDTO(CarEntity carEntity);

    public abstract List<IdNameDTO> toIdNameDTOs(List<CarEntity> carEntities);
}
