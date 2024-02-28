package com.synergisticit.config;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
	@Value("${stripe.api.secretKey}")
    private String secretKey;
	
	@Value("${openai.api.key}")
	String openaiApiKey;
	
    @PostConstruct
    public void  initSecretKey(){
        Stripe.apiKey = secretKey;
    }

    @Bean
    RestTemplate template(){
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
   
}
