package com.synergisticit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergisticit.domain.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

}
