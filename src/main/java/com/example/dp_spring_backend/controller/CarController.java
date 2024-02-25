package com.example.dp_spring_backend.controller;

import com.example.dp_spring_backend.domain.DTO.CarBasicInfoDTO;
import com.example.dp_spring_backend.domain.DTO.input.CarUpdateInputDTO;
import com.example.dp_spring_backend.domain.DTO.input.CreateCarInputDTO;
import com.example.dp_spring_backend.domain.DTO.output.CarOutputDTO;
import com.example.dp_spring_backend.domain.entity.CarEntity;
import com.example.dp_spring_backend.enums.FuelEnum;
import com.example.dp_spring_backend.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/car")
public class CarController {

    private final CarService carService;


    @GetMapping("/a")
    public String sendMail(){
        carService.sent();
        return "sent";
    }


    @GetMapping
    public ResponseEntity<List<CarEntity>> getString(){
        System.out.println("puca");
        List<CarEntity>a = new ArrayList<>();

        CarEntity car = new CarEntity();
        CarEntity cars = new CarEntity();

        car.setId(1);
        car.setFuel(FuelEnum.GAS);
        a.add(car);


        cars.setId(2);
        cars.setFuel(FuelEnum.DIESEL);
        a.add(cars);

        return ResponseEntity.ok(a);
    }

    @PostMapping
    public ResponseEntity<CarBasicInfoDTO> createCar(@RequestBody CreateCarInputDTO inputDTO){
        try{
            CarBasicInfoDTO carBasicInfoDTO = carService.create(inputDTO);
            return ResponseEntity.ok(carBasicInfoDTO);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

    @GetMapping("/all-basic-info")
    public ResponseEntity<List<CarBasicInfoDTO>> getBasicInfoCarData(){
        try{
            List<CarBasicInfoDTO> carBasicInfoDTOList = carService.getAllBasicInfoDTO();
            return ResponseEntity.ok(carBasicInfoDTOList);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

    @GetMapping("/details/{carId}")
    public ResponseEntity<CarOutputDTO> getDetails(@PathVariable Long carId){
        try{
            CarOutputDTO carOutputDTO = carService.getCarDetailsDTO(carId);
            return ResponseEntity.ok(carOutputDTO);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CarUpdateInputDTO inputDTO){
        try{
            carService.update(id,inputDTO);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            carService.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }
}
