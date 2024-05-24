package com.trabalhoum.controleassinatura.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long clientId;
    private String clientName;
    private String clientEmail;
}
