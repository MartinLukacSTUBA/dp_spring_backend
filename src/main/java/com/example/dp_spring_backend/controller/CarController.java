package com.example.dp_spring_backend.controller;

import com.example.dp_spring_backend.domain.DTO.CarBasicInfoDTO;
import com.example.dp_spring_backend.domain.DTO.input.CreateCarInputDTO;
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
}
