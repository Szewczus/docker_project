package com.example.docker_project.repositories;

import com.example.docker_project.entity.TripPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripPlanRepository extends JpaRepository<TripPlanEntity, Long> {
}
