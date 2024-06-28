package com.example.docker_project.repositories;

import com.example.docker_project.entities.PackItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackItemRepository extends JpaRepository<PackItemEntity, Long> {
    @Query(value = "select * from pack_item_entity where holiday_id=:holidayId", nativeQuery = true)
    List<PackItemEntity> findPackItemEntitiesByHoliday( Long holidayId);
}
