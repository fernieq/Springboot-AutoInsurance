
package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.*;

import com.synergisticit.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired UserRepository userRepository;
	@Autowired BCryptPasswordEncoder bCrypt;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		String hashedPassword = bCrypt.encode(user.getUserPassword());
		user.setUserPassword(hashedPassword);
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Integer uId) {
		userRepository.deleteById(uId);		
	}

	@Override
	public User findByUserId(Integer uId) {
		Optional<User> u = userRepository.findById(uId);
		if(u.isPresent()) {
			return u.get();
		} 
		return null;
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
