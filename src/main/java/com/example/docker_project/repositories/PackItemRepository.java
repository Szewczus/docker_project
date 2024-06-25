package com.example.docker_project.repositories;

import com.example.docker_project.entity.PackItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackItemRepository extends JpaRepository<PackItemEntity, Long> {
}
