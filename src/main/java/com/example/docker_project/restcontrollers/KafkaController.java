package com.example.docker_project.restcontrollers;

import com.example.docker_project.dtos.KafkaUserHolidayReportDto;
import com.example.docker_project.services.HolidayUserReportService;
import com.example.docker_project.services.KafkaProducerService;
import com.example.docker_project.dtos.HolidayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaProducerService producerService;
    @Autowired
    private HolidayUserReportService holidayUserReportService;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String topic, @RequestParam String key, @RequestBody HolidayDto message) {
        producerService.sendMessage(topic, key, message);
        return "Message sent successfully!";
    }
    @PostMapping("/sendUserReport")
    public String sendUserHolidayReport() {
        List<KafkaUserHolidayReportDto> kafkaUserHolidayReportDtoList = holidayUserReportService.getReportByLoginFromSession();
        for(KafkaUserHolidayReportDto kafkaUserHolidayReportDto : kafkaUserHolidayReportDtoList){
            producerService.sendMessage("holiday-report-topic", SecurityContextHolder.getContext().getAuthentication().getName(), kafkaUserHolidayReportDto);
        }
        return "Message sent successfully!";
    }
}
