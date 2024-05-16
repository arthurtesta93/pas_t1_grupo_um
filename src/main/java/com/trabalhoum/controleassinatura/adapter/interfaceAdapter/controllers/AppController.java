package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.controllers;

import com.trabalhoum.controleassinatura.core.service.AppService;
import com.trabalhoum.controleassinatura.domain.entities.AppEntity;
import com.trabalhoum.controleassinatura.domain.entities.dtos.AppDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping(value = "/app")
    public ResponseEntity<?> get(@RequestBody Long id) {
        AppDTO appFound;
        try{
            appFound = appService.get(id);
        }catch (IllegalArgumentException iae){
            return new ResponseEntity<>("App not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AppDTO>(appFound,HttpStatus.OK);
    }
}
