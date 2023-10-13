package com.example.dp_spring_backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {


    @GetMapping
    public ResponseEntity<String> getString(){
        System.out.println("puca");
        return ResponseEntity.ok("Hello");
    }


    @PostMapping
    public ResponseEntity<String> postString(
            @RequestBody String jozo) {
        return ResponseEntity.ok(jozo + jozo);
    }


    @PutMapping
    public ResponseEntity<String>putMapping(
            @RequestBody String jozo) {
        return ResponseEntity.ok("Hello");
    }

}
