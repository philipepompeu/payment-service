package com.github.philipepompeu.payment_service.infra.messaging;

import com.github.philipepompeu.payment_service.app.dto.PaymentQueueMessageDto;

public interface PaymentEventHandler {
    
    void handle(PaymentQueueMessageDto message);
    
}
