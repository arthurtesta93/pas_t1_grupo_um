package com.trabalhoum.controleassinatura.application.service;

import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.AppRepository;
import com.trabalhoum.controleassinatura.application.dto.AppDTO;
import com.trabalhoum.controleassinatura.core.configuration.Patcher;
import com.trabalhoum.controleassinatura.domain.entities.AppEntity;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppService {

    private AppRepository appRepository;
    private ModelMapper modelMapper;

    /*
     * Method Save: Save the AppEntity passed by parameter in the database.
     * @return an AppDTO
     */
    public AppDTO save(AppEntity appEntity){
        return modelMapper.map(appRepository.save(appEntity), AppDTO.class);
    }

    /*
     * Method get: Search the appEntity by the id passed by parameter
     * @return an AppDTO
     */
    public AppDTO get(Long id) {
        Optional<AppEntity> appEntityFound = appRepository.findAllById(id);
        if(appEntityFound.isPresent()){
            return modelMapper.map(appEntityFound, AppDTO.class);
        }else
          throw new IllegalArgumentException("App not found");
    }

    /*
     * Method get: Search the all the appEntities saved in the database
     * @return a list of appEntity
     */
    public List<AppEntity> getAll(){
        return appRepository.findAll();
    }

    /*
    * NOT WORKING YET!!!
    */
    public AppDTO upDate(Long id, AppDTO appDTO) throws IllegalAccessException {
        Optional<AppEntity> appFound;
        try {
            appFound = appRepository.findById(id);//acha app no bd
            AppEntity appNewData = modelMapper.map(appDTO, AppEntity.class); //appNewData recebe o appDTO com alteração
            Patcher.internPatcher(appFound, appNewData);//patcher faz alteração
            return appDTO;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isActive(@RequestBody Long id){
        Optional<AppEntity> appFound = appRepository.findById(id);
        return appFound.map(AppEntity::isActive).orElse(false);
    }

    public Object updateCost(Long id, double monthlyCost) {
        Optional<AppEntity> appFound = appRepository.findById(id);
        if(appFound.isPresent()){
            appFound.get().setMonthlyCost(monthlyCost);
            return appRepository.save(appFound.get());
        } else
            throw new IllegalArgumentException("App not found");
    }
}
