package com.example.dp_spring_backend.service;


import com.example.dp_spring_backend.config.JwtService;
import com.example.dp_spring_backend.domain.DTO.UserBasicInfoDTO;
import com.example.dp_spring_backend.domain.DTO.input.CreateUserInputDTO;
import com.example.dp_spring_backend.domain.DTO.output.UserOutputDTO;
import com.example.dp_spring_backend.domain.entity.User;
import com.example.dp_spring_backend.mapper.UserMapper;
import com.example.dp_spring_backend.outputDTO.UserInfoOutputDTO;
import com.example.dp_spring_backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

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

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public UserBasicInfoDTO create(CreateUserInputDTO inputDTO) {
        User user = userMapper.createUserToUser(inputDTO);
        user.setPassword(passwordEncoder.encode("password"));
        userRepository.save(user);
        return userMapper.toBasicInfoDTO(user);
    }

    public List<UserBasicInfoDTO> getAllBasicInfoDTO() {
        List<User> users = userRepository.findAllByOrderByIdAsc();
        return userMapper.toListBasicInfoDTO(users);
    }

    public UserOutputDTO getUserDetailsDTO(Long userId) throws ChangeSetPersister.NotFoundException {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findById(userId));
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return userMapper.toUserOutputDTO(user);
        } else {
            // Handle case where car with given ID is not found
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    public void update(Long id, CreateUserInputDTO inputDTO) {
        User user = userRepository.findById(id);
        userMapper.createDTOToEntity(user, inputDTO);
        userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
