package com.synergisticit.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    private LocalDate accidentDate;
    
    private String description;
    
    private String status;
    
    private double repairPrice;
    
    private String phone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "claim_id")
    private List<ClaimImage> images = new ArrayList<>();

    public Claim() {
        super();
    }

    public Claim(LocalDate accidentDate, String description, String status, Vehicle vehicle, List<ClaimImage> images, double repairPrice, String phone) {
        this.accidentDate = accidentDate;
        this.description = description;
        this.status = status;
        this.images = images;
        this.repairPrice = repairPrice;
        this.phone = phone;
    }

    // Getters and setters

    

    public LocalDate getAccidentDate() {
        return accidentDate;
    }

    public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public void setAccidentDate(LocalDate accidentDate) {
        this.accidentDate = accidentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getPhone() {
    	return phone;
    }
    
    public void setPhone(String phone) {
    	this.phone = phone;
    }



    public List<ClaimImage> getImages() {
        return images;
    }

    public void setImages(List<ClaimImage> images) {
        this.images = images;
    }
    
    public double getRepairPrice() {
    	return repairPrice;
    }
    
    public void setRepairPrice(double repairPrice) {
    	this.repairPrice = repairPrice;
    }
    
    
}