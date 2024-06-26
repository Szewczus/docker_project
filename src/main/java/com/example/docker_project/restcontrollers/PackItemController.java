package com.example.docker_project.restcontrollers;

import com.example.docker_project.dtos.PackItemDto;
import com.example.docker_project.entities.PackItemEntity;
import com.example.docker_project.services.PackItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
