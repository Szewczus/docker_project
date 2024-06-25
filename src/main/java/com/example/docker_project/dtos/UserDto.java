package com.example.docker_project.dtos;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private Boolean notificationOn = true;
}
