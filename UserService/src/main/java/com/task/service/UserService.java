package com.task.service;

import java.util.List;

import com.task.entities.User;

public interface UserService {
	
	public User getUserProfile(String jwt);

	public User findUserProfileByJwt(String jwt);

	public User findUserById(Long userId);

	public List<User> findAllUsers();

}
