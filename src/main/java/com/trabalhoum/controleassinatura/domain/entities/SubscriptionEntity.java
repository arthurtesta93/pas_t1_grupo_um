package com.trabalhoum.controleassinatura.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscription")
public class SubscriptionEntity {

    private int freeDays;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subscriptionId;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "app_id", nullable = false)
    private Long appId;

    @Column(name = "beginning_validity", nullable = false)
    private Date beginningValidity;

    @Column(name = "end_validity", nullable = false)
    private Date EndValidity;


}
