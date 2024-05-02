package com.trabalhoum.controleassinatura.core.repository;

import com.trabalhoum.controleassinatura.domain.entities.AppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppRepository extends JpaRepository<AppEntity,Long> {
    public Optional<AppEntity> findById(Long id);
}