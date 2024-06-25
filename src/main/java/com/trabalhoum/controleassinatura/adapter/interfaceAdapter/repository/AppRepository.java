package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository;

import com.trabalhoum.controleassinatura.domain.entities.AppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AppRepository extends JpaRepository<AppEntity,Long> {

    Optional<AppEntity> findAllById(Long id);
    Optional<AppEntity> findById(Long id);
    List<AppEntity> findAll();

}
