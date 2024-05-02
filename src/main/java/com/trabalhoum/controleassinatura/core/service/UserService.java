package com.trabalhoum.controleassinatura.core.service;

import com.trabalhoum.controleassinatura.core.domain.User;
import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repositories.IUserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository IUserRepository;

    public void save(User user){
        IUserRepository.save(user);
    }

}
