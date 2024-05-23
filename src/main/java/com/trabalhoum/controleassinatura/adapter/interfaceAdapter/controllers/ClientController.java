package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.controllers;

import com.trabalhoum.controleassinatura.application.DTO.ClientDTO;
import com.trabalhoum.controleassinatura.application.service.app.ClientService;
import com.trabalhoum.controleassinatura.domain.entities.ClientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
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
}
