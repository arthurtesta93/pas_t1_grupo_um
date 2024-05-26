package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.controllers;

import com.trabalhoum.controleassinatura.application.dto.ClientDTO;
import com.trabalhoum.controleassinatura.application.service.ClientService;
import com.trabalhoum.controleassinatura.domain.entities.AppEntity;
import com.trabalhoum.controleassinatura.domain.entities.ClientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/servcad")
public class ClientController {

    private ClientService clientService;
    private ModelMapper modelMapper;

    @PostMapping(value = "/clientes")
    public ResponseEntity<?> save(@RequestBody ClientDTO clientDTO){
        if(clientDTO.getClientEmail() == null || clientDTO.getClientEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Client name is required");
        }
        ClientEntity clientEntity = modelMapper.map(clientDTO, ClientEntity.class);
        clientService.save(clientEntity);
        return ResponseEntity.ok(clientEntity);

    }

    /*
     * Method getById: Search an ClientEntity by the id passed by path
     * @return ResponseEntity<?>
     */
    @GetMapping(value = "/clientes/{clientId}")
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
    @GetMapping(value = "/clientes")
    public List<ClientEntity> getAll(){
        return clientService.getAll();
    }

    /*
     * NOT WORKING YET!!!
     */
    @PatchMapping(value = "/clientes/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") Long id, @RequestBody ClientDTO clientDTO){
        ClientDTO clientToUpdate;
        try {
            clientToUpdate = modelMapper.map(clientService.upDate(id, clientDTO),ClientDTO.class);
            return new ResponseEntity<>(clientToUpdate, HttpStatus.OK);
        } catch (IllegalAccessException iae){
            System.out.println("Access Error" + iae.getMessage());
            iae.printStackTrace();
            return new ResponseEntity<>("Not able to update", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
