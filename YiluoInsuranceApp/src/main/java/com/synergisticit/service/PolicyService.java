package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Policy> findAll() {
		return policyRepository.findAll();
	}

	public Policy findById(Long policyId) {
		Optional<Policy>  policyOptional = policyRepository.findById(policyId);
		if (policyOptional != null) {
			return policyOptional.get();
		}
		return null;
	}

	public void deletePolicy(Policy policy) {
		policyRepository.delete(policy);
	}

	public void deleteById(Long policyId) {
		policyRepository.deleteById(policyId);
	}
}
