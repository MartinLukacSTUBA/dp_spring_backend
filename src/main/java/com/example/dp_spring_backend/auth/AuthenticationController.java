package com.example.dp_spring_backend.auth;

import com.example.dp_spring_backend.domain.DTO.AuthenticationRequestInputDTO;
import com.example.dp_spring_backend.domain.DTO.AuthenticationResponseDTO;
import com.example.dp_spring_backend.domain.DTO.RegisterRequestInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody RegisterRequestInputDTO request ){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(
            @RequestBody AuthenticationRequestInputDTO request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
