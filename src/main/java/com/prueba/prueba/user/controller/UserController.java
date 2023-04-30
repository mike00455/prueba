package com.prueba.prueba.user.controller;

import com.prueba.prueba.user.dto.UserRequestDto;
import com.prueba.prueba.user.dto.UserResponseDto;
import com.prueba.prueba.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveUser(@RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.saveUser(userRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/get_all")
    public ResponseEntity<?> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id")UUID userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Map<String, String>> updateUser(@RequestBody UserRequestDto userRequestDto, @PathVariable("id") UUID userId){
        return new ResponseEntity<>(userService.updateUser(userId, userRequestDto), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable("id") UUID userId){
        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }
}
