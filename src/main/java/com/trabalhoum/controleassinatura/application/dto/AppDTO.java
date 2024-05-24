package com.trabalhoum.controleassinatura.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppDTO {
    private Long id;
    private String name;
    private double monthlyCost;
    private boolean isActive;
    private List<ClientDTO> clients;
}
