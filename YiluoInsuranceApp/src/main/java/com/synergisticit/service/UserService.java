package com.synergisticit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.synergisticit.domain.*;

@Service
public interface UserService {

	public List<User> findAll();
	public User save(User u);
	public void deleteUserById(Integer uId);
	public User findByUserId(Integer uId);
	public User findByUserName(String userName);
}
