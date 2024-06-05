package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository;

import com.trabalhoum.controleassinatura.domain.entities.enums.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhoum.controleassinatura.domain.entities.SubscriptionEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
    public Optional<SubscriptionEntity> findById(Long id);

    List<SubscriptionEntity> findAll();

    //get all subscriptions by SubscriptionStatus

    List<SubscriptionEntity> findAllByStatus(SubscriptionStatus status);

    List<SubscriptionEntity> findAllByAppId(Long appId);

    //Iterable<? extends Long> findAll(Long subscriptionId);
}
