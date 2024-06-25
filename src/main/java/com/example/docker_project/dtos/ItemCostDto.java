package com.example.docker_project.dtos;

import lombok.Data;

@Data
public class ItemCostDto {
    private Long id;
    private String item;
    private Double cost;
}
