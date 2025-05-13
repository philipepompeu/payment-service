package com.github.philipepompeu.payment_service.infra.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.philipepompeu.payment_service.app.dto.PaymentQueueMessageDto;

import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
public class PaymentMessageConsumer {

    private final PaymentEventDispatcher eventDispatcher;


    @Bean
    public Consumer<PaymentQueueMessageDto> paymentConsumer() {
        return message -> {
            System.out.println("Mensagem recebida: " + message.getEvent());
            this.eventDispatcher.dispatch(message);            
        };
    }
    
}
