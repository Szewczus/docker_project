package com.example.docker_project.repositories;

import com.example.docker_project.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsUserEntitiesByLogin(String login);
}
