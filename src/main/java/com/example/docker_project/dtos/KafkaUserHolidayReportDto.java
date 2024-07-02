package com.example.docker_project.dtos;


public interface KafkaUserHolidayReportDto {
    String getTravelDestination();
    String getDestinationAddress();
    String getDescription();
    String getArriveDate();
    String getDepartureDate();
    Double getAccomodationCost();
}
