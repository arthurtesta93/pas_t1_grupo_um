package com.trabalhoum.controleassinatura.application.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentDTO {
    private Long paymentCode;
    private Long subcriptionCode;
    private Long userCode;
}
