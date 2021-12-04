package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.PhoneverificationService;
import com.example.demo.service.VerificationResult;

@Controller
public class TwilioController {

	@Autowired
	PhoneverificationService phonesmsservice;
	    
	@RequestMapping("/otp")
	public String homepage(ModelAndView model)
	{
		return "OTP";
	}
	
	@PostMapping("/sendotp")
	public ResponseEntity<String> sendotp(@RequestParam("phone") String phone)
	{
	    VerificationResult result=phonesmsservice.startVerification(phone);
	    if(result.isValid())
	    {
	    	return new ResponseEntity<>("Otp Sent..",HttpStatus.OK);
	    }
		return new ResponseEntity<>("Otp failed to sent..",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/verifyotp")
	public /*ResponseEntity<String>*/ String sendotp(@RequestParam("phone") String phone, @RequestParam("otp") String otp)
	{
	    VerificationResult result=phonesmsservice.checkverification(phone,otp);
	    if(result.isValid())
	    {
	    	//return new ResponseEntity<>("Your number is Verified",HttpStatus.OK);
	    	return "redirect:/register";
	    }
	    return null;
		//return new ResponseEntity<>("Something wrong/ Otp incorrect",HttpStatus.BAD_REQUEST);
	}
	
	
}