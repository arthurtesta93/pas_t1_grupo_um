package com.trabalhoum.controleassinatura.application.service.app;

import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.AppRepository;
import com.trabalhoum.controleassinatura.application.DTO.AppDTO;
import com.trabalhoum.controleassinatura.core.configuration.Patcher;
import com.trabalhoum.controleassinatura.domain.entities.AppEntity;

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

    public List<AppEntity> getAll(){
        return appRepository.findAll();
    }

    //public AppDTO setAppMonthlyCost(){}
    public AppDTO upDate(Long id, AppDTO appDTO) throws IllegalAccessException {
        Optional<AppEntity> appFound;
        try {
            appFound = appRepository.findById(id);
            AppEntity appNewData = modelMapper.map(appDTO, AppEntity.class);
            Patcher.internPatcher(appFound, appNewData);
            return appDTO;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isActive(@RequestBody Long id){
        Optional<AppEntity> appFound = appRepository.findById(id);
        return appFound.map(AppEntity::isActive).orElse(false);
    }
}
