package com.trabalhoum.controleassinatura.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @Column(name = "payment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentCode;

    @ManyToOne
    @JoinColumn(name = "subscription", nullable = false)
    private SubscriptionEntity subscription;

    @Column(name = "payment_value", nullable = false, precision = 2)
    private Double paymentValue;

    @Column(name = "payment_date", nullable = false)
    private Date paymentDate;

    @Column(name = "coupon")
    private Boolean coupon;

}
