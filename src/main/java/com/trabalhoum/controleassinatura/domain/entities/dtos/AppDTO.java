package com.trabalhoum.controleassinatura.domain.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppDTO {
    private Long id;
    private String name;
    private double monthlyCost;
    private boolean isActive;
}
