package com.example.docker_project.services;

import com.example.docker_project.dtos.ItemCostDto;
import com.example.docker_project.entities.ItemCostEntity;
import com.example.docker_project.repositories.HolidayRepository;
import com.example.docker_project.repositories.ItemCostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCostService {
    @Autowired
    private ItemCostRepository itemCostRepository;
    @Autowired
    private HolidayRepository holidayRepository;

    public ItemCostEntity save(ItemCostDto itemCostDto) {
        ItemCostEntity itemCostEntity = itemCostDtoToEntityConvert(itemCostDto);
        return itemCostRepository.save(itemCostEntity);
    }

    private ItemCostEntity itemCostDtoToEntityConvert(ItemCostDto itemCostDto){
        ItemCostEntity itemCostEntity = new ItemCostEntity();
        itemCostEntity.setCost(itemCostDto.getCost());
        itemCostEntity.setItem(itemCostDto.getItem());
        itemCostEntity.setHoliday(holidayRepository.findHolidayEntityById(itemCostDto.getHolidayId()));
        return itemCostEntity;
    }

    public List<ItemCostEntity> showItemsCosts(Long holidayId) {
        List<ItemCostEntity> itemCostEntities = itemCostRepository.findItemCostEntitiesByHoliday(holidayId);
        System.out.print("itemCostEntities: ");
        itemCostEntities.forEach(System.out::println);
        return itemCostEntities;
    }
}
