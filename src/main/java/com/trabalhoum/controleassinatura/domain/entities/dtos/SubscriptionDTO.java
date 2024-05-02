package com.trabalhoum.controleassinatura.domain.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SubscriptionDTO {

    private Long subscriptionCode;
    private Long userCode;
    private Long appCode;
    private Long expirationDate;
}
