package com.example.docker_project.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HolidayDto {
    private Long id;
    private String destination;
    private LocalDateTime arrive_date;
    private LocalDateTime departure_date;
    private String address;
    private Double accomodation_cost;
}
