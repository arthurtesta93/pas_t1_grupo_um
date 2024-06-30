package com.trabalhoum.controleassinatura.application.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SubscriptionStatusRequestDTO {

    private Long subscriptionId;
    private String status;


}
