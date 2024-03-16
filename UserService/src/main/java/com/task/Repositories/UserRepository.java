package com.task.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);

}
