package com.trabalhoum.controleassinatura.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @Column(name = "user_code")
    private UUID userCode;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

}
