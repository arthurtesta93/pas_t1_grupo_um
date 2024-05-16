package com.trabalhoum.controleassinatura.core.service;

import com.trabalhoum.controleassinatura.core.repository.AppRepository;
import com.trabalhoum.controleassinatura.domain.entities.AppEntity;
import com.trabalhoum.controleassinatura.domain.entities.dtos.AppDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppService {

    private AppRepository appRepository;
    private ModelMapper modelMapper;

    public AppDTO save(AppEntity appEntity){
        return modelMapper.map(appRepository.save(appEntity), AppDTO.class);
    }

    public AppDTO get(Long id){
        return modelMapper.map(appRepository.findAllById(id),AppDTO.class);
    }

}
