package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.controllers;

import com.trabalhoum.controleassinatura.application.DTO.AppDTO;
import com.trabalhoum.controleassinatura.application.service.app.AppService;
import com.trabalhoum.controleassinatura.domain.entities.AppEntity;

import lombok.AllArgsConstructor;
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

    /*
    * Method Save: Save the AppEntity passed by perameter as AppDTO
    * @return an AppDTO
    */
    @PostMapping(value = "/app")
    public AppDTO save (@RequestBody AppDTO appDTO){
        appService.save(new AppEntity(appDTO));
        return appDTO;
    }

    /*
     * Method getById: Search an AppEntity by the id passed by path
     * @return ResponseEntity<?>
     */
    @GetMapping(value = "/app/{appId}")
    public ResponseEntity<?> getById( @PathVariable("appId") Long appId) {
        System.out.println("entrei");
        AppDTO appFound;
        try{
            appFound = appService.get(appId);
        }catch (IllegalArgumentException iae){
            return new ResponseEntity<>("App not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appFound, HttpStatus.OK);
    }

    /*
     * Method getAll: Search all the AppEntities registered in the database
     * @return a list of AppEntity
     */
    @GetMapping(value = "/app")
    public List<AppEntity> getAll(){
        return appService.getAll();
    }

    /*
    * NOT WORKING YET!!!
    */
    @PatchMapping(value = "/app/{id}")
    public ResponseEntity<?> upDate(@PathVariable ("id") Long id, @RequestBody AppDTO appDTO){
        AppDTO appToUpdate;
        try{
            appToUpdate = modelMapper.map(appService.upDate(id, appDTO),AppDTO.class);
            return new ResponseEntity<AppDTO>(appToUpdate,HttpStatus.OK);
        }catch (IllegalAccessException iae){
            System.out.println("Access Error" + iae.getMessage());
            iae.printStackTrace();
            return new ResponseEntity<>("Not able to upDate", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
