package com.example.docker_project.restcontrollers;

import com.example.docker_project.dtos.HolidayDto;
import com.example.docker_project.entities.HolidayEntity;
import com.example.docker_project.services.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findHoliday/{id}")
    ResponseEntity findHolidayById(@PathVariable Long id) {
        HolidayEntity holidayEntity = holidayService.findHolidayById(id);
        if(holidayEntity==null){
            return ResponseEntity.ok("no such holiday id found in db");
        }
        return ResponseEntity.ok(holidayEntity);
    }
}
