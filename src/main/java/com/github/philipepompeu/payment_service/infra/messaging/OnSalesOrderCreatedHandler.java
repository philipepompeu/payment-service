package com.github.philipepompeu.payment_service.infra.messaging;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.philipepompeu.payment_service.app.dto.PaymentQueueMessageDto;
import com.github.philipepompeu.payment_service.domain.Payment;
import com.github.philipepompeu.payment_service.domain.PaymentRepository;
import com.github.philipepompeu.payment_service.domain.PaymentStatus;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component("onSalesOrderCreated")
@RequiredArgsConstructor
public class OnSalesOrderCreatedHandler implements PaymentEventHandler {


    private final ObjectMapper objectMapper;
    private final PaymentRepository paymentRepository;

    @Override
    public void handle(PaymentQueueMessageDto message) {

        try {
            Payment entity = objectMapper.readValue(message.getContent(), Payment.class);

            paymentRepository.findByOrderId(entity.getOrderId()).switchIfEmpty(Mono.defer(() -> {
                
                entity.setCreatedAt(LocalDateTime.now());
                entity.setId(UUID.randomUUID());
                entity.setStatus(PaymentStatus.PENDING);

                return paymentRepository.save(entity)
                    .doOnSuccess(saved -> System.out.println(String.format("Payment[id = %s] created.", saved.getId())));
            })).subscribe();            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
}
