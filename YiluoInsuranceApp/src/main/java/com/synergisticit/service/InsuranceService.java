package com.synergisticit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Insurance;
import com.synergisticit.repository.InsuranceRepository;

@Service
public class InsuranceService {

	@Autowired InsuranceRepository insuranceRepository;
	
	public Insurance addInsurance(Insurance insurance) {
		return insuranceRepository.save(insurance);
	}
}
