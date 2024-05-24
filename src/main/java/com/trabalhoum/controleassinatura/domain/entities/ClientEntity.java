package com.trabalhoum.controleassinatura.domain.entities;

import com.trabalhoum.controleassinatura.application.dto.ClientDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="client")
public class ClientEntity {

  @Id
  @Column(name="user_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long clientId;

  @Column(name="name", nullable = false)
  private String clientName;

  @Column(name="email", nullable = false)
  private String clientEmail;

  public ClientEntity(ClientDTO clientDTO){
    this.clientName = clientDTO.getClientName();
    this.clientEmail = clientDTO.getClientEmail();
  }

}
