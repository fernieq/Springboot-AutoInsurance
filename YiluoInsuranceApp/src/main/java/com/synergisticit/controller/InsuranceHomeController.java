package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.synergisticit.service.UserService;

@Controller
public class InsuranceHomeController {
	
	@Autowired UserService userService;

	@GetMapping({"/", "/home"})
	public ModelAndView insuranceHomePage() {
		ModelAndView mAndView = new ModelAndView("home");
		return mAndView;
	}
	
	@GetMapping("accessDenied") 
	public ModelAndView accessDenied(){
		ModelAndView mAndView = new ModelAndView("accessDenied");
		return mAndView;
	}
	
	@GetMapping("signup") 
	public ModelAndView signUp(){
		ModelAndView mAndView = new ModelAndView("signUp");
		return mAndView;
	}
	
	@GetMapping("autoInsurancePlan") 
	public ModelAndView autoInsurancePlan(){
		ModelAndView mAndView = new ModelAndView("autoInsurancePlan");
		return mAndView;
	}
	
}
