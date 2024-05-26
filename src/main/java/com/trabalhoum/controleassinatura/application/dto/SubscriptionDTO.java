package com.trabalhoum.controleassinatura.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class SubscriptionDTO {

    private Long subscriptionCode;
    private Long appId;
    private Long clientId;
    private Date beginningValidity;
    private Date EndValidity;
}
