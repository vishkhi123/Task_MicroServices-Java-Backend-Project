package com.taskService.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.taskService.entities.UserDto;

@FeignClient(name="Task",url="http://localhost:5001")
public interface UserService {
	
	@GetMapping("/api/users/profile")
	public UserDto getUserProfile(@RequestHeader("Authorization") String jwt );
	

}
