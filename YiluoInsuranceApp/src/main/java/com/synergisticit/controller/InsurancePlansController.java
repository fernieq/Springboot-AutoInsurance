package com.synergisticit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.synergisticit.service.UserService;
import com.synergisticit.domain.*;

@Controller
public class InsurancePlansController {
	
	@Autowired UserService userService;
	
	@GetMapping("standardPlan")
	public ModelAndView standardPlan(Principal principal){
		ModelAndView mAndView = new ModelAndView("standardPlan");
		if(principal != null) {
			User user = userService.findByUserName(principal.getName());
			System.out.println("Welcome Your Name Is------------------"+user.getUserName());
			System.out.println("Welcome Your Email Is------------------"+user.getUserEmail());
			mAndView.addObject("principal",principal.getName());
			mAndView.addObject("username", user.getUserName());
			mAndView.addObject("useremail", user.getUserEmail());
			return mAndView;
		} else {
			mAndView.addObject("user",null);
			return mAndView;
		}			
	}
	
	@GetMapping("premiumPlan")
	public ModelAndView premiumPlan(Principal principal){
		ModelAndView mAndView = new ModelAndView("premiumPlan");
		if(principal != null) {
			User user = userService.findByUserName(principal.getName());
			System.out.println("Welcome Your Name Is------------------"+user.getUserName());
			System.out.println("Welcome Your Email Is------------------"+user.getUserEmail());
			mAndView.addObject("principal",principal.getName());
			mAndView.addObject("username", user.getUserName());
			mAndView.addObject("useremail", user.getUserEmail());
			return mAndView;
		} else {
			mAndView.addObject("user",null);
			return mAndView;
		}			

	}
	
	@GetMapping("supremePlan")
	public ModelAndView supremePlan(Principal principal){
		ModelAndView mAndView = new ModelAndView("supremePlan");
		if(principal != null) {
			User user = userService.findByUserName(principal.getName());
			System.out.println("Welcome Your Name Is------------------"+user.getUserName());
			System.out.println("Welcome Your Email Is------------------"+user.getUserEmail());
			mAndView.addObject("principal",principal.getName());
			mAndView.addObject("username", user.getUserName());
			mAndView.addObject("useremail", user.getUserEmail());
			return mAndView;
		} else {
			mAndView.addObject("user",null);
			return mAndView;
		}			

	}
	
	@GetMapping("planPayment")
	public ModelAndView planPayment(Principal principal){
		ModelAndView mAndView = new ModelAndView("planPayment");
		return mAndView;
	}

}
