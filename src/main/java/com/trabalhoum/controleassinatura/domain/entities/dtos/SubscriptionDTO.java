package com.trabalhoum.controleassinatura.domain.entities.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class SubscriptionDTO {

    private Long subscriptionId;
    private Date beginningValidity;
    private Date EndValidity;
}
