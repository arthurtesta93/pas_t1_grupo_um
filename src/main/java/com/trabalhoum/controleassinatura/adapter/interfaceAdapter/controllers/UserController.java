package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.controllers;


import com.trabalhoum.controleassinatura.core.application.DTO.UserCreateRequestDTO;
import com.trabalhoum.controleassinatura.core.domain.User;
import com.trabalhoum.controleassinatura.core.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserCreateRequestDTO user) {

        User userToSave = new User();
        userToSave.setName(user.getName());
        userToSave.setEmail(user.getEmail());
        userToSave.setUserCode(UUID.randomUUID());

        try {
            userService.save(userToSave);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar usuário.");
        }

        return new ResponseEntity<>(userToSave, HttpStatus.CREATED);
    }

}
