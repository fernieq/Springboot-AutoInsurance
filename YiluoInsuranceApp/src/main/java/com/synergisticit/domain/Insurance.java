package com.synergisticit.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long insuranceId;
	@NotNull
	private LocalDate startDate;
	@NotNull
	private LocalDate endDate;
	@NotNull
	private Long deductables;
	@NotNull
	private String insuranceType;
	@NotNull
	private Long price;
	private Long duration;
	@OneToMany
	private List<Rider> riders;
	private Long finalCharges;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policyId")
	private Policy policy;
	public Long getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(Long insuranceId) {
		this.insuranceId = insuranceId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEnDate(LocalDate enDate) {
		this.endDate = enDate;
	}
	public Long getDeductables() {
		return deductables;
	}
	public void setDeductables(Long deductables) {
		this.deductables = deductables;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public List<Rider> getRiders() {
		return riders;
	}
	public void setRiders(List<Rider> riders) {
		this.riders = riders;
	}
	public Long getFinalCharges() {
		return finalCharges;
	}
	public void setFinalCharges(Long finalCharges) {
		this.finalCharges = finalCharges;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	
	public Insurance() {
		
	}
	
	public Insurance(LocalDate startDate, LocalDate endDate, Long deductables,
			String insuranceType, Long price, Long duration, Long finalCharges) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.deductables = deductables;
		this.insuranceType = insuranceType;
		this.price = price;
		this.duration = duration;
		this.finalCharges = finalCharges;
	}
	
	
	
}
