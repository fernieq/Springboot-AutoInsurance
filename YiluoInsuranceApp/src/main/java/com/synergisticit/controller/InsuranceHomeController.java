package com.synergisticit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.synergisticit.domain.Request;
import com.synergisticit.domain.User;
import com.synergisticit.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class InsuranceHomeController {
	
	@Autowired UserService userService;

	@GetMapping("home")
	public ModelAndView insuranceHomePage(Principal principal) {
		ModelAndView mAndView = new ModelAndView("home");
		if (principal != null) {
			mAndView.addObject("principal", principal.getName());
		}
		return mAndView;
	}
	
	@GetMapping("accessDenied") 
	public ModelAndView accessDenied(){
		ModelAndView mAndView = new ModelAndView("accessDenied");
		return mAndView;
	}
	
	@GetMapping("/signin")
	public String signin(@RequestParam(required = false) String logout, @RequestParam(required = false) String error,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {
		String message = "";
		if (error != null) {
			message = "Invalid Username or Password.";
		}
		if (logout != null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);
			}
			message = "You are logged out.";
			return "signin";
		}
		model.addAttribute("message", message);
		return "signin";
	}
	
	@GetMapping("signup")
	public String signup(Model model){
		 model.addAttribute("user", new User());
		return "signup";
	}
	
	
	@PostMapping("userSignUp")
	public String userSignUp(Model model, @ModelAttribute User user) {
		userService.save(user);
		return "signin";
	}
	
	@GetMapping("autoInsurancePlan") 
	public ModelAndView autoInsurancePlan(Principal principal){
		ModelAndView mAndView = new ModelAndView("autoInsurancePlan");
		if (principal != null) {
			mAndView.addObject("principal", principal.getName());
		}
		return mAndView;
	}
	
}
