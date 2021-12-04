package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserDetails;

public interface DetailsService {
		
	List<UserDetails> getAllUserDetailss();
	void saveUserDetails(UserDetails userDetails);
	boolean findUser(UserDetails userDetails);
	
}
