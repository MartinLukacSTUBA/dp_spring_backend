package com.example.dp_spring_backend.mapper;


import com.example.dp_spring_backend.domain.DTO.output.CarDiagnosticOutputDTO;
import com.example.dp_spring_backend.domain.entity.CarDiagnosticEntity;
import com.example.dp_spring_backend.service.CarService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CarDiagnosticMapper {

    @Autowired
    CarService carService;

    @Mapping(target="lastname", expression = "java(carDiagnosticEntity.getRecorderId().getLastname())")
    @Mapping(target = "carName",expression = "java(carDiagnosticEntity.getCarId().getName())")
    public abstract CarDiagnosticOutputDTO toCarDiagnosticOutputDTO(CarDiagnosticEntity carDiagnosticEntity);
}
