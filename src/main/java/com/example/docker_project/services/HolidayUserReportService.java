package com.example.docker_project.services;

import com.example.docker_project.dtos.KafkaUserHolidayReportDto;
import com.example.docker_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayUserReportService {
    @Autowired
    private UserRepository userRepository;

    public List<KafkaUserHolidayReportDto> getReportByLoginFromSession() {
        return userRepository.getReportByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
