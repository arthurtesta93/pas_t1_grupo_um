package com.trabalhoum.controleassinatura.domain.entities;

import com.trabalhoum.controleassinatura.domain.entities.dtos.AppDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="App")
public class AppEntity {

    @Id
    @Column(name = "app_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "subscription_id", nullable = false)
    private  Long subscriptionCode;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    public AppEntity(AppDTO appDTO){
        this.subscriptionCode = appDTO.getSubscriptionCode();
        this.userId = appDTO.getUserId();
        this.isActive = appDTO.isActive();
    }
}
