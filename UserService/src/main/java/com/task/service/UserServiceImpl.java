package com.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.Repositories.UserRepository;
import com.task.config.JwtProvider;
import com.task.entities.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserProfile(String jwt) {
		// TODO Auto-generated method stub
		String email= JwtProvider.getEmailFromJwtToken(jwt);
		return userRepository.findByEmail(email);
		
	}

	@Override
	public User findUserProfileByJwt(String jwt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		
		return this.userRepository.findAll();
	}

}
