package com.trabalhoum.controleassinatura.core.repository;

import com.trabalhoum.controleassinatura.domain.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
}
