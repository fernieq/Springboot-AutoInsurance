package com.synergisticit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.ClaimImage;
import com.synergisticit.repository.ClaimImageRepository;

@Service
public class ClaimImageService {

	@Autowired ClaimImageRepository claimImageRepository;

	public ClaimImage save(ClaimImage claimImage) {
		return claimImageRepository.save(claimImage);
	}
}
