package com.example.dp_spring_backend.service;

import com.example.dp_spring_backend.domain.DTO.CarBasicInfoDTO;
import com.example.dp_spring_backend.domain.DTO.input.CarUpdateInputDTO;
import com.example.dp_spring_backend.domain.DTO.input.CreateCarInputDTO;
import com.example.dp_spring_backend.domain.DTO.output.CarOutputDTO;
import com.example.dp_spring_backend.domain.DTO.output.CarOutputForEmailsDTO;
import com.example.dp_spring_backend.domain.entity.CarEntity;
import com.example.dp_spring_backend.exception.CarNotFoundException;
import com.example.dp_spring_backend.mapper.CarEntityMapper;
import com.example.dp_spring_backend.repository.CarEntityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarEntityMapper carEntityMapper;
    private final CarEntityRepository carEntityRepository;

    private final EmailService emailService;



    @Transactional
    public CarBasicInfoDTO create(CreateCarInputDTO inputDTO) {
        CarEntity carEntity =carEntityMapper.toCarEntity(inputDTO);
        carEntityRepository.save(carEntity);
        return carEntityMapper.toBasicInfoDTO(carEntity);
    }

    public List<CarBasicInfoDTO> getAllBasicInfoDTO() {
        List<CarEntity> allCars = carEntityRepository.findAllByOrderByIdAsc();
        return carEntityMapper.toListBasicInfoDTO(allCars);
    }

    public CarOutputDTO getCarDetailsDTO(Long carId) throws ChangeSetPersister.NotFoundException {
        Optional<CarEntity> carEntityOptional = carEntityRepository.findById(carId);
        if (carEntityOptional.isPresent()) {
            CarEntity carEntity = carEntityOptional.get();
            return carEntityMapper.toCarOutputDTO(carEntity);
        } else {
            // Handle case where car with given ID is not found
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    public void update(Long id, CarUpdateInputDTO inputDTO) {
        CarEntity carEntity = carEntityRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
        carEntityMapper.inputDTOToEntity(carEntity, inputDTO);
        carEntityRepository.save(carEntity);
    }


    public CarEntity findById(Long id) throws CarNotFoundException{
        return carEntityRepository.findById(id).orElseThrow(()-> new CarNotFoundException(id));
    }

    public void delete(Long id) {
        carEntityRepository.deleteById(id);
    }

    public void sent() {
    emailService.sendEmailToEmployee("subject","message","martin.lukaccr@gmail.com");
    }



    public List<CarOutputForEmailsDTO> selectAllOldData() {
        return carEntityMapper.carEntityToCarOutputForEmailsDTO(carEntityRepository.selectAllOldData());
    }


}
