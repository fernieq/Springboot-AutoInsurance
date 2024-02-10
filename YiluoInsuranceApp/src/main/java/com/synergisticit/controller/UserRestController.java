package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.synergisticit.client.UserClient;

@RestController
public class UserRestController {

	@Autowired UserClient userClient;
	
	@PostMapping("addUser")
	public String addUser(@RequestBody JsonNode user) {
		return userClient.addUser(user);
	}
}
