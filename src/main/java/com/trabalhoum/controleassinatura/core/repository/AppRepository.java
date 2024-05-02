package com.trabalhoum.controleassinatura.core.repository;

import com.trabalhoum.controleassinatura.domain.entities.AppEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<AppEntity,Long> {
}
