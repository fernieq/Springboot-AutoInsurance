package com.synergisticit.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String userPassword;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate userDOB;
	private String userEmail;
	private String userMobile;
	private Gender userGender;
	@OneToMany
	private List<Policy> userPolicies;
	@OneToMany
	private List<Document> userDocuments;
	
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
	public List<Document> getUserDocuments() {
		return userDocuments;
	}
	public void setUserDocuments(List<Document> userDocuments) {
		this.userDocuments = userDocuments;
	}
	public List<Policy> getUserPolicies() {
		return userPolicies;
	}
	public void setUserPolicies(List<Policy> userPolicies) {
		this.userPolicies = userPolicies;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public User(String userName, String userPassword, LocalDate userDOB, List<Document> userDocuments,
			String userEmail, String userMobile, Gender userGender, List<Policy> userPolicies) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userDOB = userDOB;
		this.userDocuments = userDocuments;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.userGender = userGender;
		this.userPolicies = userPolicies;
	}
	public User() {
		super();
	}
	
}
