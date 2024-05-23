package com.trabalhoum.controleassinatura.application.service.app;

import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.ClientRepository;
import com.trabalhoum.controleassinatura.application.DTO.ClientDTO;
import com.trabalhoum.controleassinatura.domain.entities.ClientEntity;
import org.modelmapper.ModelMapper;

public class ClientService {

    ClientRepository clientRepository;
    ModelMapper modelMapper;

    public ClientDTO save(ClientEntity clientEntity){
        return modelMapper.map(clientRepository.save(clientEntity), ClientDTO.class);
    }

}

