package com.example.docker_project.services;

import com.example.docker_project.dtos.UserDto;
import com.example.docker_project.entities.UserEntity;
import com.example.docker_project.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService implements UserDetailsService {
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
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
        return userRepository.save(userEntity);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserEntityByLogin(username);
        if(user == null){
            log.error("User not found in the database: {}", username);
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", user);
        }
        return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}
