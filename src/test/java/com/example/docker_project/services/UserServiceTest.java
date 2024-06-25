package com.example.docker_project.services;

import com.example.docker_project.dtos.UserDto;
import com.example.docker_project.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    void saveUserWhenUserExists() {
        //given
        UserDto userDto = new UserDto();
        userDto.setEmail("test@test.com");
        userDto.setName("test");
        userDto.setLogin("test");
        userDto.setPassword("test");
        //when
        when(userRepository.existsUserEntitiesByLogin(any(String.class))).thenReturn(Boolean.TRUE);
        //then
        userService.saveUser(userDto);
        verify(userRepository).existsUserEntitiesByLogin(any(String.class));
    }

    @Test
    void saveUserWhenUserDoesntExist() {
        //given
        UserDto userDto = new UserDto();
        userDto.setEmail("test@test.com");
        userDto.setName("test");
        userDto.setLogin("test");
        userDto.setPassword("test");
        //when
        when(userRepository.existsUserEntitiesByLogin(any(String.class))).thenReturn(Boolean.FALSE);
        //then
        userService.saveUser(userDto);
        verify(userRepository).save(any());
    }
}