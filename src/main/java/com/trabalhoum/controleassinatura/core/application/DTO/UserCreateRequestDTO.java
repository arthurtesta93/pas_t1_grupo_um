package com.trabalhoum.controleassinatura.core.application.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@AllArgsConstructor
@Getter
@Setter
public class UserCreateRequestDTO {

    private String name;
    private String email;

}
