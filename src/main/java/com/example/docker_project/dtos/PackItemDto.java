package com.example.docker_project.dtos;

import lombok.Data;

@Data
public class PackItemDto {
    private Long id;
    private String item;
    private Integer item_count;
    private String description;
}
