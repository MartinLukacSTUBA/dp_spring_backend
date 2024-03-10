package com.example.dp_spring_backend.service;

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
public class TokenService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserInfoOutputDTO getLoggedUserInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                User user = userRepository.findByEmail(userDetails.getUsername());
                return userMapper.toUserInfoOutputDTO(user);
            } else if (principal instanceof String) {
                String username = (String) principal;
                User user = userRepository.findByEmail(username);
                return userMapper.toUserInfoOutputDTO(user);
            }
        }
        return null;
    }

}
