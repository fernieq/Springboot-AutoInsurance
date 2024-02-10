package com.synergisticit.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Rider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long riderId;
	private String riderName;
	private Long duration;
	private Long price;
	@ManyToOne
	private Insurance insurance;

}
