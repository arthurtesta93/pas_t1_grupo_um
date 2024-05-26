package com.trabalhoum.controleassinatura.application.service;

import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.AppRepository;
import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.ClientRepository;
import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.SubscriptionRepository;
import com.trabalhoum.controleassinatura.application.dto.SubscriptionDTO;
import com.trabalhoum.controleassinatura.domain.entities.AppEntity;
import com.trabalhoum.controleassinatura.domain.entities.ClientEntity;
import com.trabalhoum.controleassinatura.domain.entities.SubscriptionEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<ClientEntity> clientList = clientRepository.findAll();
        for(ClientEntity client : clientList){
            List<AppEntity> appList = appRepository.findAll();
            for (AppEntity app : appList) {
                if (client.getClientId().equals(subscriptionEntity.getClientId()) && (app.getId().equals(subscriptionEntity.getAppId()))) {
                    return modelMapper.map(subscriptionRepository.save(subscriptionEntity), SubscriptionDTO.class);
                }
            }
        }
        throw new IllegalArgumentException("Subscription not found");
        }

    public List<SubscriptionEntity> getAll() {
        return subscriptionRepository.findAll();
    }
}



