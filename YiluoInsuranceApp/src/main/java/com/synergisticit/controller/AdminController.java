package com.synergisticit.controller;

import java.security.Principal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisticit.domain.Document;
import com.synergisticit.domain.Policy;
import com.synergisticit.service.DocumentService;
import com.synergisticit.service.EmailService;
import com.synergisticit.service.PolicyService;
import com.synergisticit.service.UserService;


import com.synergisticit.domain.User;

@Controller
public class AdminController {
	
	@Autowired PolicyService policyService;
	@Autowired EmailService emailService;
	@Autowired DocumentService documentService;
	@Autowired UserService userService;

	@GetMapping("/adminControl")
	public String adminControl(Principal principal, Model model) {
		model.addAttribute("policies", policyService.findAll());
		return "adminControl";	
	}
	
	@GetMapping("/viewDocuments")
	public String viewDocuments(Principal principal, Model model, @RequestParam("userId") String userId) {
		model.addAttribute("userId", userId);
		model.addAttribute("documents", documentService.findAll());
		return "viewDocuments";	
	}
	
	@GetMapping("/download")
	public ResponseEntity<Resource> download(@RequestParam("documentId") Long documentId) throws Exception {
		Document document = documentService.findById(documentId);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(document.getFileType()))
				.header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,
						"document; filename=\"" + document.getFileName()
				+ "\"")
				.body(new ByteArrayResource(document.getDriverLicense()));
	}
	
	@GetMapping("/approvePolicy")
	public String approvePolicy(Principal principal, Model model, @ModelAttribute Policy policy) {
		model.addAttribute("policies", policyService.findAll());
		Policy curPolicy = policyService.findById(policy.getPolicyId());
		curPolicy.setPolicyStatus("Approved");
        //send the user to upload the document
        CompletableFuture.runAsync(() -> {
			try {
				emailService.sendBookingConfirmationEmail(curPolicy);
				System.out.println("Email successfully sent!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		policyService.addPolicy(curPolicy);
		return "redirect:adminControl";	
	}
	
	@GetMapping("/rejectPolicy")
	public String rejectPolicy(Principal principal, Model model, @ModelAttribute Policy policy) {
		model.addAttribute("policies", policyService.findAll());
		Policy curPolicy = policyService.findById(policy.getPolicyId());
		curPolicy.setPolicyStatus("Rejected");
		//send the user to upload the document
        CompletableFuture.runAsync(() -> {
			try {
				emailService.sendBookingConfirmationEmail(curPolicy);
				System.out.println("Email successfully sent!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		policyService.addPolicy(curPolicy);
		return "redirect:adminControl";	
	}
	
	@GetMapping("/deletePolicy")
	public String deletePolicy(Principal principal, Model model, @ModelAttribute Policy policy) {
		model.addAttribute("policies", policyService.findAll());
		Policy curPolicy = policyService.findById(policy.getPolicyId());
		//remove the policy from the user
		User curUser = userService.findByUserId(curPolicy.getUser().getUserId());
		List<Policy> curPolicies = curUser.getUserPolicies();
		curPolicies.remove(curPolicy);
		curUser.setUserPolicies(curPolicies);
		userService.save(curUser);
		//remove the policy from the db
		policyService.deleteById(curPolicy.getPolicyId());
		return "redirect:adminControl";	
	}
}
