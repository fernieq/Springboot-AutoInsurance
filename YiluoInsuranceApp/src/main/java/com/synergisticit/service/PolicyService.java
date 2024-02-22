package com.synergisticit.service;

import org.aspectj.weaver.PoliceExtensionUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Policy;
import com.synergisticit.repository.PolicyRepository;

@Service
public class PolicyService {

	@Autowired PolicyRepository policyRepository;
	
	public Policy addPolicy(Policy policy) {
		return policyRepository.save(policy);
	}
}
