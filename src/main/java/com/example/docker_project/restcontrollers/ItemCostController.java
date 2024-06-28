package com.example.docker_project.restcontrollers;

import com.example.docker_project.dtos.ItemCostDto;
import com.example.docker_project.entities.ItemCostEntity;
import com.example.docker_project.services.ItemCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item/cost")
public class ItemCostController {
    @Autowired
    private ItemCostService itemCostService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody ItemCostDto itemCostDto){
        return ResponseEntity.ok(itemCostService.save(itemCostDto));
    }

    @GetMapping("/showAllItemCostsByHolidayId/{holidayId}")
    ResponseEntity<List<ItemCostEntity>> showAllItemCostsByHolidayId(@PathVariable Long holidayId) {
        return ResponseEntity.ok(itemCostService.showItemsCosts(holidayId));
    }
}
