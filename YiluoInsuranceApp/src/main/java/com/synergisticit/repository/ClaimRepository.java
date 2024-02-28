package com.synergisticit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergisticit.domain.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
