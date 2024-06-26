package com.example.docker_project.restcontrollers;

import com.example.docker_project.dtos.ItemCostDto;
import com.example.docker_project.services.ItemCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item/cost")
public class ItemCostController {
    @Autowired
    private ItemCostService itemCostService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody ItemCostDto itemCostDto){
        return ResponseEntity.ok(itemCostService.save(itemCostDto));
    }
}
