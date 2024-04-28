package com.trabalhoum.controleassinatura.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscription")
public class SubscriptionEntity {

    @Id
    @Column(name = "subscription_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subscriptionCode;

    @Column(name = "user_id", nullable = false)
    private Long userCode;

    @Column(name = "app_id", nullable = false)
    private Long appCode;

    @Column(name = "expiration_date", nullable = false)
    private Long expirationDate;


}
