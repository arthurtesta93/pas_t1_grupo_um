package com.trabalhoum.controleassinatura.core.repository;

import com.trabalhoum.controleassinatura.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
