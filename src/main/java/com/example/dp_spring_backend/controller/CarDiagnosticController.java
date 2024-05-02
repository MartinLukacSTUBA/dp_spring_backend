package com.example.dp_spring_backend.controller;

import com.example.dp_spring_backend.domain.DTO.output.CarDiagnosticOutputDTO;
import com.example.dp_spring_backend.domain.inputDTO.CarDiagnosticInputDTO;
import com.example.dp_spring_backend.service.CarDiagnosticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        try {
            carDiagnosticService.uploadCarDiagnosticEntity(carDiagnosticInputDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }


    @GetMapping("/logged-user")
    public ResponseEntity<List<CarDiagnosticOutputDTO>> getCarDiagnosticMadeByLoggedUser(){
        return ResponseEntity.ok().body(carDiagnosticService.getCarDiagnosticMadeByLoggedUser());
    }

    @GetMapping("")
    public ResponseEntity<List<CarDiagnosticOutputDTO>> getAllCarDiagnosticsOrderedByUserName(){
        return ResponseEntity.ok().body(carDiagnosticService.getAllCarDiagnosticsOrderedByUserName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDiagnosticOutputDTO> getCarDiagnosticById(@PathVariable Integer id){
        return ResponseEntity.ok().body(carDiagnosticService.getCarDiagnosticById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDiagnosticData(@PathVariable Integer id){
        carDiagnosticService.deleteCarDiagnosticData(id);
        return ResponseEntity.ok().build();
    }
}
