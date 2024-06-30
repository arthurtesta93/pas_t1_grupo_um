package com.trabalhoum.controleassinatura.application.service;

import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.AppRepository;
import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.ClientRepository;
import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.SubscriptionRepository;
import com.trabalhoum.controleassinatura.application.dto.SubscriptionDTO;
import com.trabalhoum.controleassinatura.domain.entities.AppEntity;
import com.trabalhoum.controleassinatura.domain.entities.ClientEntity;
import com.trabalhoum.controleassinatura.domain.entities.SubscriptionEntity;
import com.trabalhoum.controleassinatura.domain.entities.enums.SubscriptionStatus;
import com.trabalhoum.controleassinatura.messaging.rabbitmq.Producer;

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
    private Producer producer;

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
                    producer.sendMessage(modelMapper.map(subscriptionEntity, SubscriptionDTO.class)); //FANOUT MESSAGE
                    return modelMapper.map(subscriptionRepository.save(subscriptionEntity), SubscriptionDTO.class);
                }
            }
        }
        throw new IllegalArgumentException("Subscription not found");
        }

    public List<SubscriptionEntity> getAll() {
        return subscriptionRepository.findAll();
    }

    //update subscription status
    public SubscriptionEntity updateStatus(Long id, SubscriptionStatus status) {
        SubscriptionEntity subscription = getById(id);
        subscription.setStatus(status);
        producer.sendMessage(modelMapper.map(subscription, SubscriptionDTO.class)); //FANOUT MESSAGE
        return subscriptionRepository.save(subscription);
    }

    // filter subscriptions by status
    public List<SubscriptionEntity> getAllByStatus(SubscriptionStatus status) {
    return subscriptionRepository.findAllByStatus(status);
    }

    public SubscriptionEntity getById(Long id) {
        return subscriptionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Subscription not found"));
    }

    public List<SubscriptionEntity> getByAppId(Long appId) {
        return subscriptionRepository.findAllByAppId(appId);
    }
}



