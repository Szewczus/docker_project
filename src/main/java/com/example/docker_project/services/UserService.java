package com.example.docker_project.services;

import com.example.docker_project.dtos.UserDto;
import com.example.docker_project.entities.UserEntity;
import com.example.docker_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity saveUser(UserDto userDto) {
        if(Boolean.TRUE.equals(userRepository.existsUserEntitiesByLogin(userDto.getLogin()))){
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(userDto.getLogin());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setName(userDto.getName());
        userEntity.setSurname(userDto.getSurname());
        userEntity.setPassword(userDto.getPassword());
        return userRepository.save(userEntity);
    }
}
