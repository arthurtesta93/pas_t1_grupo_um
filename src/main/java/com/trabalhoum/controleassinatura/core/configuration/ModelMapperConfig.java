package com.trabalhoum.controleassinatura.core.configuration;

import com.trabalhoum.controleassinatura.application.dto.SubscriptionDTO;
import com.trabalhoum.controleassinatura.domain.entities.SubscriptionEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // Explicit mapping configuration
        modelMapper.typeMap(SubscriptionDTO.class, SubscriptionEntity.class).addMappings(mapper -> {
            mapper.map(SubscriptionDTO::getAppId, SubscriptionEntity::setAppId);
            mapper.map(SubscriptionDTO::getClientId, SubscriptionEntity::setClientId);
            mapper.map(SubscriptionDTO::getBeginningValidity, SubscriptionEntity::setBeginningValidity);
            mapper.map(SubscriptionDTO::getEndValidity, SubscriptionEntity::setEndValidity);
        });

        return modelMapper;
    }
}
