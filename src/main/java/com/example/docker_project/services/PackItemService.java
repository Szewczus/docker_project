package com.example.docker_project.services;

import com.example.docker_project.dtos.PackItemDto;
import com.example.docker_project.entities.PackItemEntity;
import com.example.docker_project.repositories.HolidayRepository;
import com.example.docker_project.repositories.PackItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackItemService {
    @Autowired
    private PackItemRepository packItemRepository;

    @Autowired
    private HolidayRepository holidayRepository;

    public PackItemEntity save(PackItemDto packItemDto) {
        PackItemEntity packItemEntity=packItemDtoToPackItemEntity(packItemDto);
        return packItemRepository.save(packItemEntity);
    }

    private PackItemEntity packItemDtoToPackItemEntity(PackItemDto packItemDto) {
        PackItemEntity packItemEntity = new PackItemEntity();
        packItemEntity.setItem(packItemDto.getItem());
        packItemEntity.setItem_count(packItemDto.getItem_count());
        packItemEntity.setDescription(packItemDto.getDescription());
        packItemEntity.setHoliday(holidayRepository.findHolidayEntityById(packItemDto.getHolidayId()));
        return packItemEntity;
    }
}
