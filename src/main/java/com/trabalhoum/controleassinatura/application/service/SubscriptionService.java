package com.trabalhoum.controleassinatura.application.service;

import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.SubscriptionRepository;
import com.trabalhoum.controleassinatura.application.dto.SubscriptionDTO;
import com.trabalhoum.controleassinatura.domain.entities.SubscriptionEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SubscriptionService {

    private SubscriptionRepository subscriptionRepository;
    private ModelMapper modelMapper;

    /*
     * Method Save: Save the SubscriptionEntity passed by parameter in the database.
     * @return an SubscriptionDTO
     */
    public SubscriptionDTO save(SubscriptionEntity subscriptionEntity){
        for(Long id:subscriptionRepository.findAll(subscriptionEntity.getSubscriptionId())){
            if(id.equals(subscriptionEntity.getSubscriptionId())) {
                return modelMapper.map(subscriptionRepository.save(subscriptionEntity), SubscriptionDTO.class);
            }
        }
        throw new IllegalArgumentException("Subscription not found");
        }
    }


