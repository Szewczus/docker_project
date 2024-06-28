package com.example.docker_project.repositories;

import com.example.docker_project.entities.TripPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripPlanRepository extends JpaRepository<TripPlanEntity, Long> {
    @Query(value = "select * from trip_plan_point_entity where holiday_id=:holidayId", nativeQuery = true)
    List<TripPlanEntity> findTripPlanEntitiesByHolidaId(Long holidayId);
}
