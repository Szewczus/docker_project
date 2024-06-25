package com.example.docker_project.repositories;

import com.example.docker_project.entities.ItemCostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCostRepository extends JpaRepository<ItemCostEntity, Long> {
}