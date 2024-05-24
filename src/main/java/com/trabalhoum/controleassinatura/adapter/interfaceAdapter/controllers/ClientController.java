package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.controllers;

import com.trabalhoum.controleassinatura.application.dto.ClientDTO;
import com.trabalhoum.controleassinatura.application.service.ClientService;
import com.trabalhoum.controleassinatura.domain.entities.ClientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class ClientController {

    private ClientService clientService;
    private ModelMapper modelMapper;

    @PostMapping(value = "client")
    public ResponseEntity<String> save(ClientEntity clientEntity){
        if(clientEntity.getClientEmail() == null || clientEntity.getClientEmail().isEmpty()) {
           return ResponseEntity.badRequest().body("Client email is required");
        }
        clientService.save(clientEntity);
        return ResponseEntity.ok("Client created successfully");
    }
}
