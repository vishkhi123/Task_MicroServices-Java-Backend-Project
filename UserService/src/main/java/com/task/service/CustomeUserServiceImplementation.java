package com.task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.task.Repositories.UserRepository;
import com.task.entities.User;

@Service
public class CustomeUserServiceImplementation implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=this.userRepository.findByEmail(username);
		if(user==null) {

			throw new UsernameNotFoundException("user not found with email  - "+username);
		}
		
		List<GrantedAuthority> authorities=new ArrayList<>();

		return new org.springframework.security.core.userdetails.User(
				user.getEmail(),user.getPassword(),authorities);

	}

}
