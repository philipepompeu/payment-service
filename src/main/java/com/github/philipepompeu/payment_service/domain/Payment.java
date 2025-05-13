package com.github.philipepompeu.payment_service.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Document(collection = "payments")
public class Payment {

    
    @Id
    private UUID id;
    private LocalDateTime createdAt;
    private PaymentStatus status;

    private String orderId;
    private BigDecimal value;
    private String payerId;
    private String payerEmail;
    private String payerPhone;
    
}
