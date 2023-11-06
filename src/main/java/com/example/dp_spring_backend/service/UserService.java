package com.example.dp_spring_backend.service;


import com.example.dp_spring_backend.config.JwtService;
import com.example.dp_spring_backend.domain.entity.User;
import com.example.dp_spring_backend.mapper.UserMapper;
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
    private final UserMapper userMapper;
    private final JwtService jwtService;
    public UserInfoOutputDTO getLoggedUserInfo(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
//            String userId = userDetails.getUsername(); // Assuming the username is used as the user's ID
            User user = userRepository.findByEmail(userDetails.getUsername());
            return userMapper.toUserInfoOutputDTO(user);
        }
        return null;
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }
}
