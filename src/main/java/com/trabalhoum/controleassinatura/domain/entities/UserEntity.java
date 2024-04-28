package com.trabalhoum.controleassinatura.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="'user'")
public class UserEntity {

  @Id
  @Column(name="user_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userCode;

}
