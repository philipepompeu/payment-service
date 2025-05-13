package com.github.philipepompeu.payment_service.app.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PaymentQueueMessageDto {
    
    private String event;    
    private String content;
    private LocalDateTime createdAt;

    
}
