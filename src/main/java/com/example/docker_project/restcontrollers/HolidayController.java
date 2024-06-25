package com.example.docker_project.restcontrollers;

import com.example.docker_project.dtos.HolidayDto;
import com.example.docker_project.entities.HolidayEntity;
import com.example.docker_project.services.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holiday")
public class HolidayController {
    @Autowired
    private HolidayService holidayService;

    @PostMapping("/save")
    ResponseEntity addHoliday(@RequestBody HolidayDto holidayDto) {
        HolidayEntity holidayEntity = holidayService.saveHoliday(holidayDto);
        return ResponseEntity.ok(holidayEntity);
    }
}
