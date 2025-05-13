package com.github.philipepompeu.payment_service.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.github.philipepompeu.payment_service.app.PaymentService;
import com.github.philipepompeu.payment_service.domain.Payment;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @QueryMapping(name = "payments")
    public Flux<Payment> getAllPayments(){
        System.out.println("Chamada ao método getAllPayments");

        return this.paymentService.getAllPayments().onErrorResume(err ->{

            System.out.println("Deu erro ->" + err.getMessage());
            return Flux.empty();
        });
    }

    @MutationMapping(name = "updatePaymentToCompleted")
    public Mono<Payment> updatePaymentToCompleted(@Argument String id) {
        return this.paymentService.paymentCompleted(id);
    };

}
    

