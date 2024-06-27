package com.example.docker_project.repositories;

import com.example.docker_project.entities.ItemCostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCostRepository extends JpaRepository<ItemCostEntity, Long> {
    @Query(value = "select * from item_cost_entity where item_cost_entity.holiday_id=?1", nativeQuery = true)
    List<ItemCostEntity> findItemCostEntitiesByHoliday(Long holidayId);
}
