package com.example.docker_project.services;

import com.example.docker_project.dtos.HolidayDto;
import com.example.docker_project.entities.HolidayEntity;
import com.example.docker_project.repositories.HolidayRepository;
import com.example.docker_project.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HolidayService {
    @Autowired
    HolidayRepository holidayRepository;
    @Autowired
    UserRepository userRepository;

    public HolidayEntity saveHoliday(HolidayDto holidayDto) {
        HolidayEntity holidayEntity = holidayDtoToHolidayEntity(holidayDto);
        return holidayRepository.save(holidayEntity);
    }

    private HolidayEntity holidayDtoToHolidayEntity(HolidayDto holidayDto) {
        HolidayEntity holiday = new HolidayEntity();
        holiday.setId(holidayDto.getId());
        holiday.setAddress(holidayDto.getAddress());
        holiday.setDestination(holidayDto.getDestination());
        holiday.setAccomodation_cost(holidayDto.getAccomodation_cost());
        holiday.setArrive_date(holidayDto.getArrive_date());
        holiday.setDeparture_date(holidayDto.getDeparture_date());
        holiday.setUser(userRepository.findUserEntityByLogin(getLoginFromSession()));
        return holiday;
    }

    private String getLoginFromSession(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String loginFromSession = authentication.getPrincipal().toString();
        log.info("Login from session: " + loginFromSession);
        return loginFromSession;
    }
}
