package com.synergisticit.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@Component
public class UserClient {
	public String addUser(JsonNode user) {
		RestTemplate restTemplate = new RestTemplate();
        HttpEntity<JsonNode> requestEntity = new HttpEntity<>(user);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8383" + "/addUser", requestEntity, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK || responseEntity.getStatusCode() == HttpStatus.CREATED) {
            String responseBody = responseEntity.getBody();
            return responseBody;
        } else {
            String errorMessage = "Error: Received HTTP status " + responseEntity.getStatusCodeValue();
            return errorMessage;
        }		
	}
}
