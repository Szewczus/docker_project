package com.example.docker_project.repositories;

import com.example.docker_project.entities.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayEntity, Long> {
    HolidayEntity findHolidayEntityById(Long id);
}
