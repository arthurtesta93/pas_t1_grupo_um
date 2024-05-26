package com.trabalhoum.controleassinatura.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class PaymentDTO {
    private Long paymentCode;
    private Long subcriptionCode;
    private Double paymentValue;
    private Date paymentDate;
    private String coupon;

}
