package com.example.dp_spring_backend.service;


import com.example.dp_spring_backend.config.JwtService;
import com.example.dp_spring_backend.outputDTO.UserInfoOutputDTO;
import com.example.dp_spring_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    public UserInfoOutputDTO getLoggedUserInfo(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            String userId = userDetails.getUsername(); // Assuming the username is used as the user's ID
        }
        return null;
    }

}
