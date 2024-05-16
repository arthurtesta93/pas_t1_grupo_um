package com.trabalhoum.controleassinatura.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class ClientEntity {

  @Id
  @Column(name="user_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long clientId;

  @Column(name="name", nullable = false)
  private String clientName;

  @Column(name="email", nullable = false)
  private String clientEmail;

}
