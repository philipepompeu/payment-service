package com.github.philipepompeu.payment_service.infra.messaging;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.github.philipepompeu.payment_service.app.dto.PaymentQueueMessageDto;

@Component
public class PaymentEventDispatcher {

    private final Map<String, PaymentEventHandler> handlers;

    public PaymentEventDispatcher(Map<String, PaymentEventHandler> handlers) {
        this.handlers = handlers;
    }

    public void dispatch(PaymentQueueMessageDto message) {
        PaymentEventHandler handler = handlers.get(message.getEvent());
        if (handler != null) {
            handler.handle(message);
        } else {
            System.out.println("Evento não tratado: " + message.getEvent());
        }
    }
    
}
