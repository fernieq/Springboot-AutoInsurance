package com.synergisticit.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatGPTController {
	
	@GetMapping("chatGPT")
	public String chatGPT(Principal principal, Model model) {
		model.addAttribute("curUser", principal.getName());
		return "chatGPT";
	}

}
