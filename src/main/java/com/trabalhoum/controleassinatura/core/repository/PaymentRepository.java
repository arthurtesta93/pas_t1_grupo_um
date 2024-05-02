package com.trabalhoum.controleassinatura.core.repository;

import com.trabalhoum.controleassinatura.domain.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
