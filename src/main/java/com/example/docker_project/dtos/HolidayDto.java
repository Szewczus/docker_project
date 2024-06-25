package com.example.docker_project.dtos;

import lombok.Data;
@Data
public class HolidayDto {
    private Long id;
    private String destination;
    private String arrive_date;
    private String departure_date;
    private String address;
    private Double accomodation_cost;
}
