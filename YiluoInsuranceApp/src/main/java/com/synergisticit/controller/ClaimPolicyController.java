package com.synergisticit.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.synergisticit.domain.ClaimImage;
import com.synergisticit.domain.Policy;
import com.synergisticit.domain.User;
import com.synergisticit.service.ClaimImageService;
import com.synergisticit.service.ClaimService;
import com.synergisticit.service.PolicyService;
import com.synergisticit.service.UserService;

@Controller
public class ClaimPolicyController {
	
	@Autowired UserService userService;
	@Autowired PolicyService policyService;
	@Autowired ClaimService claimService;
	@Autowired ClaimImageService claimImageService;

	@GetMapping("claimIntimationPortal")
	public String claimPolicy(Principal principal, Model model) {
		return "claimIntimationPortal";
	}
	
	@PostMapping("searchMyPlans")
	public String searchMyPlans(Principal principal, Model model, 
			@RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail) throws Exception{
		try {
    		List<User> users = userService.findAll();
    		for (User user : users) {
    			if (user.getUserName().equals(userName) && user.getUserEmail().equals(userEmail)) {
    				model.addAttribute("verified", true);
    				List<Policy> allPolicies = policyService.findAll();
    				List<Policy> curUserPolicies = new ArrayList<>();
    				for (Policy policy : allPolicies) {
    					if (policy.getUser().getUserId().equals(user.getUserId())) {
    						curUserPolicies.add(policy);
    					}
    				}
    				model.addAttribute("policies", curUserPolicies);
    				return "claimIntimationPortal";
    			} else {
    				model.addAttribute("msg", "User Name or User Email Does Not Match With The System.");
    			}
    		}
		} catch (Exception e) {
			throw new Exception("Encountered some errors!");
		}
		return "claimIntimationPortal";
	}
	
	@GetMapping("claimIntimationChoice")
	public String claimIntimation(Model model, @RequestParam("policyId") Long policyId) {
		Policy curPolicy = policyService.findById(policyId);
		model.addAttribute("curUser", curPolicy.getUser().getUserName());
		model.addAttribute("policyName", curPolicy.getPolicyName());
		model.addAttribute("policyStatus", curPolicy.getPolicyStatus());
		model.addAttribute("insuranceStartDate", curPolicy.getInsurance().getStartDate());
		model.addAttribute("insuranceEndDate", curPolicy.getInsurance().getEndDate());
		model.addAttribute("insurancePlanType", curPolicy.getInsurance().getInsuranceType());
		model.addAttribute("insuranceTotalCost", curPolicy.getInsurance().getFinalCharges());
		model.addAttribute("insuranceMonthlyPrice", curPolicy.getInsurance().getPrice());
		return "claimIntimationChoice";
	}
	
	@PostMapping("uploadClaimImage") 
    public String uploadClaimImage(Model model,  @RequestParam("claimimage") MultipartFile file) throws Exception {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			
      		if(fileName.contains("..")) {
    			throw new Exception("Filename contains invalid path sequence" + fileName);
    		}
   			//create the download url
    		String downloadUrl = "";
    		downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
    					.path("/download")
   						.toUriString();
   			ClaimImage claimImage = new ClaimImage(fileName, file.getContentType(), file.getBytes(), downloadUrl);
    		//save the claimimage to the db
   			claimImageService.save(claimImage);
   	    	return "claimIntimationChoice";
		} catch (Exception e) {
			throw new Exception("Could not upload the claim image: " + fileName);
		}    				
    }
}
