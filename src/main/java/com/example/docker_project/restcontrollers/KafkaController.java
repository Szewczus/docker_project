package com.example.docker_project.restcontrollers;

import com.example.docker_project.services.KafkaProducerService;
import com.example.docker_project.dtos.HolidayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String topic, @RequestParam String key, @RequestBody HolidayDto message) {
        producerService.sendMessage(topic, key, message);
        return "Message sent successfully!";
    }
}
