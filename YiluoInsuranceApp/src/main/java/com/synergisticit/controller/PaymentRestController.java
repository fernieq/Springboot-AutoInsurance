package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.synergisticit.client.PaymentClient;

@RestController
public class PaymentRestController {
	
	@Autowired PaymentClient paymentClient;
	
	@PostMapping("addPlan")
	public String addPlan(@RequestBody JsonNode plan) {
		return paymentClient.addPlan(plan);
	}
}
