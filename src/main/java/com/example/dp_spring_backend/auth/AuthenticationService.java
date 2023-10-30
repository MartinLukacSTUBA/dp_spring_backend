package com.example.dp_spring_backend.auth;

import com.example.dp_spring_backend.config.JwtService;
import com.example.dp_spring_backend.domain.DTO.AuthenticationRequestInputDTO;
import com.example.dp_spring_backend.domain.DTO.AuthenticationResponseDTO;
import com.example.dp_spring_backend.domain.DTO.RegisterRequestInputDTO;
import com.example.dp_spring_backend.domain.entity.User;
import com.example.dp_spring_backend.enums.RoleEnum;
import com.example.dp_spring_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponseDTO register(RegisterRequestInputDTO request)throws ResponseStatusException {


        User existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser != null) { // Check if an existing user is found
            // You can customize the exception message or create a custom exception class
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already taken.");
        }

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(RoleEnum.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponseDTO authenticate(AuthenticationRequestInputDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}
