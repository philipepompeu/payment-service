package com.github.philipepompeu.payment_service.infra.messaging;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.philipepompeu.payment_service.app.dto.PaymentQueueMessageDto;
import com.github.philipepompeu.payment_service.domain.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Component("onSalesOrderUpdated")
@RequiredArgsConstructor
public class OnSalesOrderUpdatedHandler implements PaymentEventHandler {

    private final ObjectMapper objectMapper;
    private final PaymentRepository paymentRepository;

    @Override
    public void handle(PaymentQueueMessageDto message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }
    
}
