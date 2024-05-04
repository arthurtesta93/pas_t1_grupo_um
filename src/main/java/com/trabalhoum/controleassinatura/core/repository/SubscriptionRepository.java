package com.trabalhoum.controleassinatura.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhoum.controleassinatura.domain.entities.SubscriptionEntity;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
    public Optional<SubscriptionEntity> findById(Long id);
}