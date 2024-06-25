package com.trabalhoum.controleassinatura.application.service;

import com.trabalhoum.controleassinatura.adapter.interfaceAdapter.repository.PaymentRepository;
import com.trabalhoum.controleassinatura.application.dto.PaymentDTO;
import com.trabalhoum.controleassinatura.domain.entities.PaymentEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service

public class PaymentService {

    private PaymentRepository paymentRepository;
    private ModelMapper modelMapper;

    public PaymentDTO save(PaymentEntity payment) {
        return modelMapper.map(paymentRepository.save(payment), PaymentDTO.class);
    }


}
