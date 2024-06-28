package com.example.docker_project.restcontrollers;

import com.example.docker_project.dtos.TripPlanDto;
import com.example.docker_project.entities.TripPlanEntity;
import com.example.docker_project.services.TripPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip/plan")
public class TripPlanController {
    @Autowired
    private TripPlanService tripPlanService;

    @PostMapping("/save")
    public ResponseEntity createTripPlan(@RequestBody TripPlanDto tripPlanDto){
        TripPlanEntity tripPlanEntity = tripPlanService.createTripPlan(tripPlanDto);
        return ResponseEntity.ok(tripPlanEntity);
    }

    @GetMapping("/showTripPlanByHolidayId/{holidayId}")
    public ResponseEntity<List<TripPlanEntity>> showTripPlanByHolidayId(@PathVariable Long holidayId){
        List<TripPlanEntity> tripPlanEntities = tripPlanService.showTripPanByHolidayId(holidayId);
        return ResponseEntity.ok(tripPlanEntities);
    }
}
