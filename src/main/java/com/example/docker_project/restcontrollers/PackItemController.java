package com.example.docker_project.restcontrollers;

import com.example.docker_project.dtos.PackItemDto;
import com.example.docker_project.entities.PackItemEntity;
import com.example.docker_project.services.PackItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pack/item")
public class PackItemController {
    @Autowired
    private PackItemService packItemService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody PackItemDto packItemDto){
        PackItemEntity packItemEntity = packItemService.save(packItemDto);
        return ResponseEntity.ok(packItemEntity);
    }

    @GetMapping("/showByHolidayId/{holidayId}")
    public ResponseEntity<List<PackItemEntity>> showPackItemsByHolidayId(@PathVariable Long holidayId){
        List<PackItemEntity>packItemEntities = packItemService.showAllUserPackItem(holidayId);
        return ResponseEntity.ok(packItemEntities);
    }

}
