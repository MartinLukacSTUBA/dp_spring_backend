package com.example.dp_spring_backend.service;

import com.example.dp_spring_backend.domain.DTO.output.CarDiagnosticOutputDTO;
import com.example.dp_spring_backend.domain.entity.CarDiagnosticEntity;
import com.example.dp_spring_backend.domain.entity.User;
import com.example.dp_spring_backend.domain.inputDTO.CarDiagnosticInputDTO;
import com.example.dp_spring_backend.mapper.CarDiagnosticMapper;
import com.example.dp_spring_backend.mapper.UserMapper;
import com.example.dp_spring_backend.outputDTO.UserInfoOutputDTO;
import com.example.dp_spring_backend.repository.CarDiagnosticRepository;
import com.example.dp_spring_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarDiagnosticService {

    private final CarDiagnosticRepository carDiagnosticRepository;
    private final UserRepository userRepository;

    private final UserService userService;

    private final UserMapper userMapper;
    private final CarDiagnosticMapper carDiagnosticMapper;

    public void uploadCarDiagnosticEntity(CarDiagnosticInputDTO carDiagnosticInputDTO) {
        UserInfoOutputDTO userInfoOutputDTO = userService.getLoggedUserInfo();
        User userr = userRepository.findByEmail(userInfoOutputDTO.getEmail());
        var carDiagnosticData = CarDiagnosticEntity.builder()
                .averageRpm(carDiagnosticInputDTO.getAverageRpm())
                .averageEngineLoad(carDiagnosticInputDTO.getAverageEngineLoad())
                .averageSpeed(carDiagnosticInputDTO.getAverageSpeed())
                .averageFuelPressure(carDiagnosticInputDTO.getAverageFuelPressure())
                .averageEngineTemperature(carDiagnosticInputDTO.getAverageEngineTemperature())
                .averageThrottlePosition(carDiagnosticInputDTO.getAverageThrottlePosition())
                .startAddress(carDiagnosticInputDTO.getStartAddress())
                .startLatitude(carDiagnosticInputDTO.getStartLatitude())
                .startLongitude(carDiagnosticInputDTO.getStartLongitude())
                .endAddress(carDiagnosticInputDTO.getEndAddress())
                .endLatitude(carDiagnosticInputDTO.getEndLatitude())
                .endLongitude(carDiagnosticInputDTO.getEndLongitude())
                .recorderId(userr)
                .diagnosticTimeDate(LocalDateTime.now())
                .build();

        carDiagnosticRepository.save(carDiagnosticData);
    }

    public List<CarDiagnosticOutputDTO> getCarDiagnosticMadeByLoggedUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
//            String userId = userDetails.getUsername(); // Assuming the username is used as the user's ID
            User user = userRepository.findByEmail(userDetails.getUsername());
            List<CarDiagnosticEntity> carDiagnosticEntityList = carDiagnosticRepository.findByRecorderId_IdOrderByRecorderId_LastnameAscDiagnosticTimeDateAscStartAddressAsc(user.getId());

            List<CarDiagnosticOutputDTO> carDiagnosticOutputDTOList = carDiagnosticEntityList.stream()
                    .map(carDiagnosticMapper::toCarDiagnosticOutputDTO)
                    .toList();

            return carDiagnosticOutputDTOList;
           // return carDiagnosticMapper.toCarDiagnosticOutputDTOList(carDiagnosticRepository.findByRecorderId_Id(user.getId()));
        }
        return null;
    }

    public List<CarDiagnosticOutputDTO> getAllCarDiagnosticsOrderedByUserName() {
        List<CarDiagnosticEntity> carDiagnosticEntityList = carDiagnosticRepository.findAll_OrderByRecorderId_LastnameAscDiagnosticTimeDateAsc();
        List<CarDiagnosticOutputDTO> carDiagnosticOutputDTOList = carDiagnosticEntityList.stream()
            .map(carDiagnosticMapper::toCarDiagnosticOutputDTO)
            .toList();
        return carDiagnosticOutputDTOList;
    }

    public CarDiagnosticOutputDTO getCarDiagnosticById(Integer id) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
//            String userId = userDetails.getUsername(); // Assuming the username is used as the user's ID
            User user = userRepository.findByEmail(userDetails.getUsername());
            CarDiagnosticEntity carDiagnosticEntity = carDiagnosticRepository.findById(id).orElseThrow();
            CarDiagnosticOutputDTO carDiagnosticOutputDTO = carDiagnosticMapper.toCarDiagnosticOutputDTO(carDiagnosticEntity);


            return carDiagnosticOutputDTO;
        }
        return null;
    }

    public void deleteCarDiagnosticData(Integer id) {
        carDiagnosticRepository.deleteById(id);
    }


}
