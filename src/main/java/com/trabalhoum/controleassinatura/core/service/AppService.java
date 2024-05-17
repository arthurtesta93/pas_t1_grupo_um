package com.trabalhoum.controleassinatura.core.service;

import com.trabalhoum.controleassinatura.core.application.DTO.ApplicationDTO;
import com.trabalhoum.controleassinatura.core.configuration.Patcher;
import com.trabalhoum.controleassinatura.core.repository.AppRepository;
import com.trabalhoum.controleassinatura.domain.entities.AppEntity;
import com.trabalhoum.controleassinatura.domain.entities.dtos.AppDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public AppDTO get(Long id){
        return modelMapper.map(appRepository.findAllById(id),AppDTO.class);
    }

    public List<AppEntity> getAll(){
        return appRepository.findAll();
    }

    //public AppDTO setAppMonthlyCost(){}
    public ResponseEntity<?> upDate(Long id, AppDTO appDTO) throws IllegalAccessException {
        Optional<AppEntity> appFound;
        try {
            appFound = appRepository.findById(id);
            AppEntity appNewData = modelMapper.map(appDTO, AppEntity.class);
            Patcher.internPatcher(appFound, appNewData);
            return new ResponseEntity<>(appNewData, HttpStatus.OK);
        }catch (IllegalArgumentException iae){
            return new ResponseEntity<>("App not found", HttpStatus.NOT_FOUND);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isActive(@RequestBody Long id){
        Optional<AppEntity> appFound = appRepository.findById(id);
        return appFound.map(AppEntity::isActive).orElse(false);
    }
}
