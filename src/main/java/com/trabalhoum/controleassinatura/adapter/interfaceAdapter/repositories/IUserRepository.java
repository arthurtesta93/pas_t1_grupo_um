package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repositories;

import com.trabalhoum.controleassinatura.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface IUserRepository extends JpaRepository<User, String> {

}
