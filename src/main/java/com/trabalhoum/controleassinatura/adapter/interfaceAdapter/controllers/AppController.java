package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.controllers;

import com.trabalhoum.controleassinatura.core.service.AppService;
import com.trabalhoum.controleassinatura.domain.entities.AppEntity;
import com.trabalhoum.controleassinatura.domain.entities.dtos.AppDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class AppController {

    private AppService appService;

    @PostMapping(value = "/app")
    public AppDTO save (@RequestBody AppDTO appDTO){
        appService.save(new AppEntity(appDTO));
        return appDTO;
    }

    @GetMapping(value = "/")
    public String get(){
        return "teste";
    }
}
