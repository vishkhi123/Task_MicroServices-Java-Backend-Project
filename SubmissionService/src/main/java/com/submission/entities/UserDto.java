package com.submission.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
    private Long id;
    private String fullName;
    private String email;
  
    private String role;

}
