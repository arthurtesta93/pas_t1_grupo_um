package com.trabalhoum.controleassinatura.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.trabalhoum.controleassinatura.application.DTO.AppDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="App")
public class AppEntity {

    private int freeDays;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "clients_id", nullable = false)
    private List<ClientEntity> clients;


    @Id
    @Column(name = "app_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "monthly_cost", nullable = false)
    private double monthlyCost;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    public AppEntity(AppDTO appDTO){
        this.name = appDTO.getName();
        this.monthlyCost = appDTO.getMonthlyCost();
        this.isActive = appDTO.isActive();
    }
}
