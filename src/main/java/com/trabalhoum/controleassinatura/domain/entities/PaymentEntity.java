package com.trabalhoum.controleassinatura.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @Column(name = "payment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentCode;

    @Column(name = "subscription_id", nullable = false)
    private Long subcriptionCode;

    @Column(name = "user_id", nullable = false)
    private Long userCode;
}
