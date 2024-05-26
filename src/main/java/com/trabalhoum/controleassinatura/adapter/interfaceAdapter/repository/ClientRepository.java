package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository;

import com.trabalhoum.controleassinatura.domain.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    //Iterable<? extends Long> findAll(Long clientId);

    List<ClientEntity> findAll();

}
