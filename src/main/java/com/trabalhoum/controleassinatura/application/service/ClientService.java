package com.trabalhoum.controleassinatura.application.service;

import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.ClientRepository;
import com.trabalhoum.controleassinatura.application.dto.ClientDTO;
import com.trabalhoum.controleassinatura.core.configuration.Patcher;
import com.trabalhoum.controleassinatura.domain.entities.ClientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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

    /*
     * Method get: Search the all the clientEntities saved in the database
     * @return a list of ClientEntity
     */
    public List<ClientEntity> getAll(){
        return clientRepository.findAll();
    }

    /*
     * NOT WORKING YET!!!
     */
    public ClientDTO upDate(Long id, ClientDTO clientDTO) throws IllegalAccessException {
        Optional<ClientEntity> clientFound;
        try {
            clientFound = clientRepository.findById(id);//acha app no bd
            ClientEntity clientNewData = modelMapper.map(clientDTO, ClientEntity.class); //appNewData recebe o appDTO com alteração
            Patcher.internPatcher(clientFound, clientNewData);//patcher faz alteração
            return clientDTO;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}

