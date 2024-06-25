package com.example.docker_project.restcontrollers;

import com.example.docker_project.dtos.UserDto;
import com.example.docker_project.entities.UserEntity;
import com.example.docker_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDto userDto) {
        UserEntity userEntity = userService.saveUser(userDto);
        return ResponseEntity.ok(userEntity);
    }
}
