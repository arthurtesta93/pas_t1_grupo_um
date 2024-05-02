package com.trabalhoum.controleassinatura.core.service;

import com.trabalhoum.controleassinatura.core.repository.AppRepository;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    AppRepository appRepository;

    public Long save(Long id){
        return appRepository.save(id);
    }

    //public Long upDate()
}
