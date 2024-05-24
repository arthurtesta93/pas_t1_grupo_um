package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.controllers;

import com.trabalhoum.controleassinatura.application.DTO.AppDTO;
import com.trabalhoum.controleassinatura.application.DTO.ClientDTO;
import com.trabalhoum.controleassinatura.application.service.app.ClientService;
import com.trabalhoum.controleassinatura.domain.entities.ClientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class ClientController {

    ClientService clientService;
    ModelMapper modelMapper;

    @PostMapping(value = "client")
    public ClientDTO save(ClientEntity clientEntity){
        return modelMapper.map(clientService.save(clientEntity), ClientDTO.class);
    }

    /*
     * Method getById: Search an AppEntity by the id passed by path
     * @return ResponseEntity<?>
     */
    @GetMapping(value = "/client/{clientId}")
    public ResponseEntity<?> getById(@PathVariable("clientId") Long clientId) {
        AppDTO appFound;
        try{
            appFound = clientService.get(clientId);
        }catch (IllegalArgumentException iae){
            return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appFound, HttpStatus.OK);
    }
}
