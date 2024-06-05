package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.controllers;


import com.trabalhoum.controleassinatura.application.dto.PaymentDTO;
import com.trabalhoum.controleassinatura.application.service.PaymentService;
import com.trabalhoum.controleassinatura.domain.entities.PaymentEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/registrarpagamento")
@RestController
@AllArgsConstructor
public class PaymentController {

    private PaymentService paymentService;
    private ModelMapper modelMapper;

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody PaymentDTO paymentDTO){
        PaymentEntity paymentEntity = modelMapper.map(paymentDTO, PaymentEntity.class);
        paymentService.save(paymentEntity);

        return ResponseEntity.ok().build();

    }

}
