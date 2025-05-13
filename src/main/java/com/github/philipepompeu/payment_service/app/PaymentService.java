package com.github.philipepompeu.payment_service.app;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.github.philipepompeu.payment_service.domain.Payment;
import com.github.philipepompeu.payment_service.domain.PaymentRepository;
import com.github.philipepompeu.payment_service.domain.PaymentStatus;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PaymentService {
    
    private final PaymentRepository repository;


    public Flux<Payment> getAllPayments(){

        return this.repository.findAll();
    }

    public Mono<Payment> paymentCompleted(String paymentId){
        
        return repository.findById(UUID.fromString(paymentId))
            .flatMap((found)->{

                found.setStatus(PaymentStatus.COMPLETED);

                return repository.save(found)
                    .doOnSuccess(saved -> System.out.println(String.format("Payment[id = %s] completed.", saved.getId())));
        });

         
    }
}
