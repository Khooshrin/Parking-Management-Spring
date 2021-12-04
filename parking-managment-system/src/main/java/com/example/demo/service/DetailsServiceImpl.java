package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.DetailsRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class DetailsServiceImpl implements DetailsService{

	@Autowired
	private DetailsRepository detailsRepository;
	@Override
	public List<UserDetails> getAllUserDetailss() {
		return detailsRepository.findAll();
	}
	
	@Override
	public void saveUserDetails(UserDetails userDetails) {
		String VerLink=RandomString.make(60);
		userDetails.setVerify(VerLink);
		this.detailsRepository.save(userDetails);
		
	}
	
	@Override
	public boolean findUser(UserDetails userDetails) {
		if((this.detailsRepository.existsById(userDetails.getUsername())==true)&&(this.detailsRepository.getById(userDetails.getUsername()).getPassword()).compareTo(userDetails.getPassword())==0)
			return true;
		else
			return false;
	}
}
