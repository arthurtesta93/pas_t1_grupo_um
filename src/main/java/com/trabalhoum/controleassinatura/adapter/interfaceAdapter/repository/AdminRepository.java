package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository;

import com.trabalhoum.controleassinatura.domain.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Long>{
    public Optional<AdminEntity> findById(Long id);
}
