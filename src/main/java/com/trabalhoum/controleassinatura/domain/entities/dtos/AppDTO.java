package com.trabalhoum.controleassinatura.domain.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppDTO {
    private Long id;
    private Long subscriptionCode;
    private Long userId;
    private boolean isActive;
}
