package com.trabalhoum.controleassinatura.domain.entities.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientDTO {
    private Long clientId;
    private String clientName;
    private String clientEmail;
}
