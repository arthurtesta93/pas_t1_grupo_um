package com.trabalhoum.controleassinatura.adapter.interfaceAdapter.controllers;


import com.trabalhoum.controleassinatura.application.dto.SubscriptionDTO;
import com.trabalhoum.controleassinatura.domain.entities.SubscriptionEntity;
import com.trabalhoum.controleassinatura.application.service.SubscriptionService;
import com.trabalhoum.controleassinatura.application.utils.ValidationUtil;
import com.trabalhoum.controleassinatura.domain.entities.enums.SubscriptionStatus;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/servcad")
@RestController
@AllArgsConstructor
public class SubscriptionController {


    private SubscriptionService subscriptionService;
    private ModelMapper modelMapper;

    @GetMapping(value = "/assinaturas")
    public List<SubscriptionEntity> getAll(){
        return subscriptionService.getAll();
    }

    @PostMapping(value = "/assinaturas")
    public ResponseEntity<?> save(@RequestBody SubscriptionDTO subscriptionDTO){
        List<String> missingFields = ValidationUtil.getMissingFields(subscriptionDTO);

        if(!missingFields.isEmpty()){
            return ResponseEntity.badRequest().body("Missing fields: " + missingFields);
        }

        SubscriptionEntity subscriptionEntity = modelMapper.map(subscriptionDTO, SubscriptionEntity.class);
        subscriptionService.save(subscriptionEntity);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/assinaturas/tipo")
    public ResponseEntity<List<SubscriptionEntity>> getByStatus(@RequestParam SubscriptionStatus status) {
        List<SubscriptionEntity> subscriptions = subscriptionService.getAllByStatus(status);
        return ResponseEntity.ok(subscriptions);
    }

    @GetMapping("/asscli/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        SubscriptionEntity subscriptionEntity = subscriptionService.getById(id);
        return ResponseEntity.ok(subscriptionEntity);
    }

    @GetMapping("/assapp/{appId}")
    public ResponseEntity<?> getByAppId(@PathVariable Long appId) {
        List<SubscriptionEntity> subscriptionEntity = subscriptionService.getByAppId(appId);
        return ResponseEntity.ok(subscriptionEntity);
    }









}
