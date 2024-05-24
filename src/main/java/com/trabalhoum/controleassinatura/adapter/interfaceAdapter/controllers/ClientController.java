package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.controllers;

import com.trabalhoum.controleassinatura.application.dto.ClientDTO;
import com.trabalhoum.controleassinatura.application.service.ClientService;
import com.trabalhoum.controleassinatura.domain.entities.ClientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /*
     * NOT WORKING YET!!!
     */
    @PatchMapping(value = "/client/{id}")
    public ResponseEntity<?> upDate(@PathVariable ("id") Long id, @RequestBody ClientDTO clientDTO){
        ClientDTO clientToUpdate;
        try{
            clientToUpdate = modelMapper.map(clientService.upDate(id, clientDTO),ClientDTO.class);
            return new ResponseEntity<ClientDTO>(clientToUpdate,HttpStatus.OK);
        }catch (IllegalAccessException iae){
            System.out.println("Access Error" + iae.getMessage());
            iae.printStackTrace();
            return new ResponseEntity<>("Not able to upDate", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
