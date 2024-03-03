package com.example.dp_spring_backend.mapper;


import com.example.dp_spring_backend.domain.DTO.output.CarDiagnosticOutputDTO;
import com.example.dp_spring_backend.domain.entity.CarDiagnosticEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CarDiagnosticMapper {

//    @Mapping(target="recorderId", expression = "java(carDiagnosticEntity.getRecorderId().getId())")
    public abstract CarDiagnosticOutputDTO toCarDiagnosticOutputDTO(CarDiagnosticEntity carDiagnosticEntity);
}
