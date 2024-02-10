package com.synergisticit.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vin;
    
    //@Column(name = "make", unique = true)
    private String make;
    
    //@Column(name = "model", unique = true)
    private String model;
       
    //@Column(unique = true)
    private String year;
     
    @OneToOne
    private User user;

    public Vehicle() {
        super();
    }
    

    public Vehicle(String vin, String make, String model, String year) {
    	this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    public String getVin() {
    	return vin;
    }
    
    public void setVin(String vin) {
    	this.vin = vin;
    }

}
