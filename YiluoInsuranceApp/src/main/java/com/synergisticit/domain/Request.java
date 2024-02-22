package com.synergisticit.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.*;

public class Request {
	private String customerName;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endDate;
	
	@NotNull
	private Long duration;
	
	@NotNull
	private Long deductables;
	
	@NotBlank
	private String type;
	
    @NotNull
    @Min(4)
    private Long amount;

    @Email
    private String email;

    @NotBlank
    @Size(min = 5, max = 200)
    private String productName;

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Long getDeductables() {
		return deductables;
	}

	public void setDeductables(Long deductables) {
		this.deductables = deductables;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Request(@NotBlank String customerName, LocalDate startDate, LocalDate endDate, @NotNull Long duration,
			@NotNull Long deductables, @NotBlank String type, @NotNull @Min(4) Long amount, @Email String email,
			@NotBlank @Size(min = 5, max = 200) String productName) {
		super();
		this.customerName = customerName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.deductables = deductables;
		this.type = type;
		this.amount = amount;
		this.email = email;
		this.productName = productName;
	}

	public Request() {
		super();
	}


    
	
}