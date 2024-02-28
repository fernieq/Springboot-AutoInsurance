package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.synergisticit.domain.ChatGPTRequest;
import com.synergisticit.domain.ChatGPTResponse;

@RestController
public class ChatGPTRestController {

	@Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired RestTemplate template;
	
    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){
        // create a request
        ChatGPTRequest request = new ChatGPTRequest(model, prompt);
        
        // call the API
        ChatGPTResponse response = template.postForObject(apiURL, request, ChatGPTResponse.class);
        
        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }
        
        // return the first response
        return response.getChoices().get(0).getMessage().getContent();

    }
	
}
