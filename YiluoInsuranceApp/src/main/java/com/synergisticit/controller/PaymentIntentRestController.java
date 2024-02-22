package com.synergisticit.controller;

import com.synergisticit.domain.Request;
import com.synergisticit.domain.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentIntentRestController {
    @PostMapping("/create-payment-intent")
    public Response createPaymentIntent(@RequestBody Request request) 
            throws StripeException {
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(request.getAmount() * 100L)
                        .putMetadata("productName", 
                                request.getProductName())
                        .setCurrency("usd")
                        .setAutomaticPaymentMethods(
                                PaymentIntentCreateParams
                                        .AutomaticPaymentMethods
                                        .builder()
                                        .setEnabled(true)
                                        .build()
                        )
                        .build();

        PaymentIntent intent = 
                PaymentIntent.create(params);

        return new Response(intent.getId(),
                intent.getClientSecret());
    }
    
    @GetMapping("/getPaymentIntent/pi_3OjV29EXT9y22Nke1qfxBMX7")
    public void getPaymentIntent() throws StripeException {
    	 PaymentIntent intent = 
                 PaymentIntent.retrieve("pi_3OjV29EXT9y22Nke1qfxBMX7");
    	 System.out.println(intent);
    }
}