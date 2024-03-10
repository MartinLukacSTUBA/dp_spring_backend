package com.example.dp_spring_backend.controller;

import com.example.dp_spring_backend.domain.DTO.UserBasicInfoDTO;
import com.example.dp_spring_backend.domain.DTO.input.CreateUserInputDTO;
import com.example.dp_spring_backend.domain.DTO.output.UserOutputDTO;
import com.example.dp_spring_backend.outputDTO.UserInfoOutputDTO;
import com.example.dp_spring_backend.service.TokenService;
import com.example.dp_spring_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final TokenService tokenService;
    @GetMapping("/b")
    public String takeAllFormDb(){
        userService.dataFromDb();
        return "sent";
    }


    @GetMapping
    public ResponseEntity<String> getString(){
        System.out.println("puca");
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/logged")
    public ResponseEntity<UserInfoOutputDTO> getUserInfo(){
        return ResponseEntity.ok(tokenService.getLoggedUserInfo());
    }

    @PostMapping("")
    public ResponseEntity<UserBasicInfoDTO> createUser(@RequestBody CreateUserInputDTO inputDTO){
        try{
            UserBasicInfoDTO userBasicInfoDTO = userService.create(inputDTO);
            return ResponseEntity.ok(userBasicInfoDTO);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }
    @GetMapping("/all-basic-info")
    public ResponseEntity<List<UserBasicInfoDTO>> getBasicInfoUserData(){
        try{
            List<UserBasicInfoDTO> userBasicInfoDTOS = userService.getAllBasicInfoDTO();
            return ResponseEntity.ok(userBasicInfoDTOS);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

    @GetMapping("/details/{userId}")
    public ResponseEntity<UserOutputDTO> getDetails(@PathVariable Long userId){
        try{
            UserOutputDTO userOutputDTO = userService.getUserDetailsDTO(userId);
            return ResponseEntity.ok(userOutputDTO);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CreateUserInputDTO inputDTO){
        try{
            userService.update(id,inputDTO);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            userService.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }




//    @PostMapping
//    public ResponseEntity<String> postString(
//            @RequestBody String jozo) {
//        return ResponseEntity.ok(jozo + jozo);
//    }


    @PutMapping
    public ResponseEntity<String>putMapping(
            @RequestBody String jozo) {
        return ResponseEntity.ok("Hello");
    }

}
