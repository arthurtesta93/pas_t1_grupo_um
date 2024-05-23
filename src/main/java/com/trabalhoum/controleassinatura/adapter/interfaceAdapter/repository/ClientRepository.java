package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository;

import com.trabalhoum.controleassinatura.domain.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    public ClientEntity findById();
}
