package com.example.docker_project.repositories;

import com.example.docker_project.entity.PackItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackItemRepository extends JpaRepository<PackItemEntity, Long> {
}
