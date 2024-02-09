package com.example.dp_spring_backend.service;

import com.example.dp_spring_backend.domain.DTO.CarBasicInfoDTO;
import com.example.dp_spring_backend.domain.DTO.input.CreateCarInputDTO;
import com.example.dp_spring_backend.domain.entity.CarEntity;
import com.example.dp_spring_backend.repository.CarEntityRepository;
import com.example.dp_spring_backend.mapper.CarEntityMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarEntityMapper carEntityMapper;
    private final CarEntityRepository carEntityRepository;


    @Transactional
    public CarBasicInfoDTO create(CreateCarInputDTO inputDTO) {
        CarEntity carEntity =carEntityMapper.toCarEntity(inputDTO);
        carEntityRepository.save(carEntity);
        return carEntityMapper.toBasicInfoDTO(carEntity);
    }
}
