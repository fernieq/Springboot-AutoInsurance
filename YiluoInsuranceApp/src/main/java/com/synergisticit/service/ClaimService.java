package com.synergisticit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.repository.ClaimRepository;

@Service
public class ClaimService {

	@Autowired ClaimRepository claimRepository;
	
	
	
}
