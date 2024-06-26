package com.example.docker_project.services;

import com.example.docker_project.dtos.TripPlanDto;
import com.example.docker_project.entities.TripPlanEntity;
import com.example.docker_project.repositories.HolidayRepository;
import com.example.docker_project.repositories.TripPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripPlanService {
    @Autowired
    private TripPlanRepository tripPlanRepository;
    @Autowired
    private HolidayRepository holidayRepository;

    public TripPlanEntity createTripPlan(TripPlanDto tripPlanDto) {
        TripPlanEntity tripPlanEntity = tripPlanDtoToTripPlanEntity(tripPlanDto);
        return tripPlanRepository.save(tripPlanEntity);
    }

    private TripPlanEntity tripPlanDtoToTripPlanEntity(TripPlanDto tripPlanDto) {
        TripPlanEntity tripPlanEntity = new TripPlanEntity();
        tripPlanEntity.setDescription(tripPlanDto.getDescription());
        tripPlanEntity.setHoliday(holidayRepository.findHolidayEntityById(tripPlanDto.getHolidayId()));
        return tripPlanEntity;
    }
}