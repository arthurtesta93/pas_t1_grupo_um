package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.controllers;


import com.trabalhoum.controleassinatura.application.dto.AppDTO;
import com.trabalhoum.controleassinatura.application.dto.ClientDTO;
import com.trabalhoum.controleassinatura.application.dto.ClientDTO;
import com.trabalhoum.controleassinatura.application.service.ClientService;
import com.trabalhoum.controleassinatura.application.service.ClientService;
import com.trabalhoum.controleassinatura.domain.entities.AppEntity;
import com.trabalhoum.controleassinatura.domain.entities.ClientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ClientController {

    private ClientService clientService;
    private ModelMapper modelMapper;

    @PostMapping(value = "/client")
    public ResponseEntity<String> save(@RequestBody ClientDTO clientDTO){
        if(clientDTO.getClientEmail() == null || clientDTO.getClientEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Client name is required");
        }
        clientService.save(modelMapper.map(clientDTO, ClientEntity.class));
        return ResponseEntity.ok("Client created successfully");

    }

    /*
     * Method getById: Search an ClientEntity by the id passed by path
     * @return ResponseEntity<?>
     */
    @GetMapping(value = "/client/{clientId}")
    public ResponseEntity<?> getById(@PathVariable("clientId") Long clientId) {
        ClientDTO appFound;
        try{
            appFound = clientService.get(clientId);
        }catch (IllegalArgumentException iae){
            return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appFound, HttpStatus.OK);
    }

    /*
     * Method getAll: Search all the ClientEntities registered in the database
     * @return a list of ClientEntity
     */
    @GetMapping(value = "/client")
    public List<ClientEntity> getAll(){
        return clientService.getAll();
    }
}
