package com.trabalhoum.controleassinatura.application.service;

import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.ClientRepository;
import com.trabalhoum.controleassinatura.application.dto.AppDTO;
import com.trabalhoum.controleassinatura.application.dto.ClientDTO;
import com.trabalhoum.controleassinatura.domain.entities.AppEntity;
import com.trabalhoum.controleassinatura.domain.entities.ClientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientService {

    private ClientRepository clientRepository;
    private ModelMapper modelMapper;

    public ClientDTO save(ClientEntity clientEntity){
        return modelMapper.map(clientRepository.save(clientEntity), ClientDTO.class);
    }

    /*
     * Method get: Search the clientEntity by the id passed by parameter
     * @return an ClientDTO
     */
    public ClientDTO get(Long id) {
        Optional<ClientEntity> clientEntityFound = clientRepository.findById(id);
        if(clientEntityFound.isPresent()){
            return modelMapper.map(clientEntityFound, ClientDTO.class);
        }else
            throw new IllegalArgumentException("App not found");
    }
}

