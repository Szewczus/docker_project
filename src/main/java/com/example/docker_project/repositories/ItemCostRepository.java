package com.example.docker_project.repositories;

import com.example.docker_project.entity.ItemCostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCostRepository extends JpaRepository<ItemCostEntity, Long> {
}
