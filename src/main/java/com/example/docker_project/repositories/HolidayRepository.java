package com.example.docker_project.repositories;

import com.example.docker_project.entity.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<HolidayEntity, Long> {
}
