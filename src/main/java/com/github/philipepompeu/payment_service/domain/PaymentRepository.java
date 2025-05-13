package com.github.philipepompeu.payment_service.domain;

import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface PaymentRepository extends ReactiveMongoRepository<Payment, UUID>{    

    Mono<Payment> findByOrderId(String orderId);
    
}
