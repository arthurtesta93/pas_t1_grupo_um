package com.trabalhoum.controleassinatura.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionEntity extends JpaRepository<SubscriptionEntity, Long> {
    public Optional<SubscriptionEntity> findById(Long id);
}
