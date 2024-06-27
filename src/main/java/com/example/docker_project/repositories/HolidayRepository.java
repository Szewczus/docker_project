package com.example.docker_project.repositories;

import com.example.docker_project.entities.HolidayEntity;
import com.example.docker_project.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayEntity, Long> {
    HolidayEntity findHolidayEntityById(Long id);
    List<HolidayEntity> findHolidayEntitiesByUser(UserEntity user);
}
