package com.synergisticit.controller;

import com.synergisticit.domain.Insurance;
import com.synergisticit.domain.Policy;
import com.synergisticit.domain.Request;
import com.synergisticit.domain.User;
import com.synergisticit.service.EmailService;
import com.synergisticit.service.InsuranceService;
import com.synergisticit.service.PolicyService;
import com.synergisticit.service.UserService;

import jakarta.validation.Valid;

import java.security.Principal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StripePaymentController {
	
	@Autowired EmailService emailService;
	@Autowired UserService userService;
	@Autowired InsuranceService insuranceService;
	@Autowired PolicyService policyService;

	@Value("${stripe.api.publicKey}")
    private String publicKey;
	
    @GetMapping("/payment")
    public String payment(Model model, Principal principal){
    	if (principal != null) {
    		
    		User curUser = userService.findByUserName(principal.getName());
            model.addAttribute("customerName", curUser.getUserName());
            model.addAttribute("customerEmail", curUser.getUserEmail());
            model.addAttribute("customerMobile", curUser.getUserMobile());
    	}
        model.addAttribute("request", new Request());
        return "payment";
    }
    
    @PostMapping("/")
    public String showCard(@ModelAttribute @Valid Request request,
                               BindingResult bindingResult,
                               Model model, Principal principal){
        if (bindingResult.hasErrors()){
            return "payment";
        }
        
        Insurance insurance = new Insurance(request.getStartDate(), 
        									request.getEndDate(), 
        									request.getDeductables(), 
        									request.getType(), 
        									request.getAmount(),
        									request.getDuration(),
        									request.getAmount());
        
        switch (request.getType()) {
        case "STANDARD":
        
          insurance.setPrice((long) 999);
          break;
        case "PREMIUM":
        	insurance.setPrice((long) 1999);
          break;
        case "SUPREME":
        	insurance.setPrice((long) 3999);
          break;
      }
        
        
        //get the current user
        User curUser = userService.findByUserName(principal.getName());
        //create a new policy
        Policy policy = new Policy("Purchased", request.getProductName(), insurance, curUser);
        //assign the new policy to the user
        List<Policy> curUserPolicies = curUser.getUserPolicies();
        curUserPolicies.add(policy);
        curUser.setUserPolicies(curUserPolicies);
        
        //save the insurance to the db
        insurance.setPolicy(policy);
        insuranceService.addInsurance(insurance);
        System.out.println("Insurance successfully added to the database");
        //save the policy to the db
        policyService.addPolicy(policy);
        System.out.println("Policy successfully added to the database");

        
        request.setCustomerName(curUser.getUserName());
        request.setEmail(curUser.getUserEmail());

        model.addAttribute("publicKey", publicKey);
        model.addAttribute("email", request.getEmail());
        model.addAttribute("amount", request.getAmount());       
        model.addAttribute("productName", request.getProductName());
        
        //send the user to upload the document
        CompletableFuture.runAsync(() -> {
			try {
				emailService.sendBookingConfirmationEmail(policy, request);
				System.out.println("Email successfully sent!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
        return "checkout";
    }
         
    @GetMapping("/paymentSuccess")
    public String paymentSuccess(Model model){
        return "paymentSuccess";
    }
}
