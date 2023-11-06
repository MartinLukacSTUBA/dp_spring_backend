package com.example.dp_spring_backend.controller;

import com.example.dp_spring_backend.outputDTO.UserInfoOutputDTO;
import com.example.dp_spring_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> getString(){
        System.out.println("puca");
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/logged")
    public ResponseEntity<UserInfoOutputDTO> getUserInfo(){
        return ResponseEntity.ok(userService.getLoggedUserInfo());
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
