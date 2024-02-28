package com.synergisticit.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;
	private String policyStatus;
	private String policyName;
	@OneToOne(cascade = CascadeType.ALL)
	private Insurance insurance;
	@ManyToOne
	private User user;
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Policy(String policyStatus, String policyName, Insurance insurance, User user) {
		super();
		this.policyStatus = policyStatus;
		this.policyName = policyName;
		this.insurance = insurance;
		this.user = user;
	}
	public Policy() {
		super();
	}
	
}
