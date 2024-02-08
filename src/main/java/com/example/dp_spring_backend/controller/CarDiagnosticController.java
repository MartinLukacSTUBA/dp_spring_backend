package com.example.dp_spring_backend.controller;

import com.example.dp_spring_backend.domain.inputDTO.CarDiagnosticInputDTO;
import com.example.dp_spring_backend.outputDTO.CarDiagnosticOutputDTO;
import com.example.dp_spring_backend.service.CarDiagnosticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/car-diagnostic")
public class CarDiagnosticController {

    private final CarDiagnosticService carDiagnosticService;
    @PostMapping
    public ResponseEntity<?> uploadCarDiagnosticEntity(@RequestBody CarDiagnosticInputDTO carDiagnosticInputDTO) {
        System.out.println("jozjo");
        carDiagnosticService.uploadCarDiagnosticEntity(carDiagnosticInputDTO);
        return ResponseEntity.ok("Ok");
    }

    @GetMapping
    public ResponseEntity<List<CarDiagnosticOutputDTO>> getCarDiagnosticMadeByLoggedUser(){
        return ResponseEntity.ok().body(carDiagnosticService.getCarDiagnosticMadeByLoggedUser());
    }
}
