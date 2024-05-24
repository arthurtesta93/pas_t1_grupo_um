package com.trabalhoum.controleassinatura.application.service;

import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.ClientRepository;
import com.trabalhoum.controleassinatura.application.dto.ClientDTO;
import com.trabalhoum.controleassinatura.domain.entities.ClientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class ClientService {

    private ClientRepository clientRepository;
    private ModelMapper modelMapper;

    public ClientDTO save(ClientEntity clientEntity){
        return modelMapper.map(clientRepository.save(clientEntity), ClientDTO.class);
    }

}

