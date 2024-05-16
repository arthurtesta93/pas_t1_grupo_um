package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.controllers;

import com.trabalhoum.controleassinatura.core.application.DTO.ApplicationDTO;
import com.trabalhoum.controleassinatura.core.service.AppService;
import com.trabalhoum.controleassinatura.domain.entities.AppEntity;
import com.trabalhoum.controleassinatura.domain.entities.dtos.AppDTO;
import lombok.AllArgsConstructor;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class AppController {

    private AppService appService;
    private ModelMapper modelMapper;

    @PostMapping(value = "/app")
    public AppDTO save (@RequestBody AppDTO appDTO){
        appService.save(new AppEntity(appDTO));
        return appDTO;
    }

    @GetMapping(value = "/app/{appId}")
    public ResponseEntity<?> getById( @PathVariable Long appId) {
        AppDTO appFound;
        try{
            appFound = appService.get(appId);
        }catch (IllegalArgumentException iae){
            return new ResponseEntity<>("App not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appFound, HttpStatus.OK);
    }

    @GetMapping(value = "/app")
    public List<AppEntity> getAll(){
        return appService.getAllApplications();
    }
}
