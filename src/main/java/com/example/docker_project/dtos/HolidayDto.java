package com.example.docker_project.dtos;

import lombok.Data;
@Data
public class HolidayDto {
    private Long id;
    private String travel_destination;
    private String destination_address;
    private String arrive_date;
    private String departure_date;
    private Double accomodation_cost;
}
