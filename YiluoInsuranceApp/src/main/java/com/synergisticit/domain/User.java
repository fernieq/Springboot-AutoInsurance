package com.synergisticit.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private Integer userAge;
	private String userPassword;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate userDOB;
	private String userEmail;
	private String userMobile;
	private Gender userGender;
	@OneToMany
	private List<Policy> userPolicies;
	@OneToOne(cascade = CascadeType.ALL)
	private Address userAddress;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_role")
	private Set<Role> roles = new HashSet<>();
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public LocalDate getUserDOB() {
		return userDOB;
	}
	public void setUserDOB(LocalDate userDOB) {
		this.userDOB = userDOB;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public Gender getUserGender() {
		return userGender;
	}
	public void setUserGender(Gender userGender) {
		this.userGender = userGender;
	}
	public List<Policy> getUserPolicies() {
		return userPolicies;
	}
	public void setUserPolicies(List<Policy> userPolicies) {
		this.userPolicies = userPolicies;
	}
	public Address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public User(Integer userId, String userName, Integer userAge, String userPassword, LocalDate userDOB,
			String userEmail, String userMobile, Gender userGender, List<Policy> userPolicies, Address userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.userPassword = userPassword;
		this.userDOB = userDOB;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.userGender = userGender;
		this.userPolicies = userPolicies;
		this.userAddress = userAddress;
	}
	
}
