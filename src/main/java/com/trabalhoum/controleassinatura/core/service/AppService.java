package com.trabalhoum.controleassinatura.core.service;

import com.trabalhoum.controleassinatura.core.application.DTO.ApplicationDTO;
import com.trabalhoum.controleassinatura.core.repository.AppRepository;
import com.trabalhoum.controleassinatura.domain.entities.AppEntity;
import com.trabalhoum.controleassinatura.domain.entities.dtos.AppDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppService {

    private AppRepository appRepository;
    private ModelMapper modelMapper;

    public AppDTO save(AppEntity appEntity){
        return modelMapper.map(appRepository.save(appEntity), AppDTO.class);
    }

//    public AppDTO get(Long id){
//        return modelMapper.map(appRepository.findAllById(id),AppDTO.class);
//    }

    public AppDTO get(Long id) {
        Optional<AppEntity> optionalAppEntity = appRepository.findAllById(id);
        if (optionalAppEntity.isPresent()) {
            AppEntity appEntity = optionalAppEntity.get();
            return modelMapper.map(appEntity, AppDTO.class);
        } else {
            throw new IllegalArgumentException("App not found");
        }
    }


    public List<AppEntity> getAllApplications(){
        return appRepository.findAll();
    }

}
