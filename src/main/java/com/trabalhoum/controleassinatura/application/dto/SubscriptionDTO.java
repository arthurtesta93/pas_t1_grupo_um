package com.trabalhoum.controleassinatura.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDTO {

    private Long appId;
    private Long clientId;
    private Date beginningValidity;
    private Date endValidity;

}
