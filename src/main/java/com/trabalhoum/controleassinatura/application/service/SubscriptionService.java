package com.trabalhoum.controleassinatura.application.service;

import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.AppRepository;
import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.ClientRepository;
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
    private ClientRepository clientRepository;
    private AppRepository appRepository;
    private ModelMapper modelMapper;

    /*
     * Method Save: Save the SubscriptionEntity passed by parameter in the database.
     * @return an SubscriptionDTO
     */
    public SubscriptionDTO save(SubscriptionEntity subscriptionEntity){
        for(Long clientId:clientRepository.findAll(subscriptionEntity.getClientId())) {
            for (Long appId : appRepository.findAll(subscriptionEntity.getAppId())) {
                if (clientId.equals(subscriptionEntity.getClientId()) && (appId.equals(subscriptionEntity.getAppId()))) {
                    return modelMapper.map(subscriptionRepository.save(subscriptionEntity), SubscriptionDTO.class);
                }
            }
        }
        throw new IllegalArgumentException("Subscription not found");
        }
    }


