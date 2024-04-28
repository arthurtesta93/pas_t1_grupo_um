package com.trabalhoum.controleassinatura.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class AdminEntity {

    @Id
    @Column(name = "admin_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminCode;
}
