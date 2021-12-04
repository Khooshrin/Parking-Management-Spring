package com.example.demo.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Twilioproperties;
import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {

	
	private Twilioproperties twilioproperties;
	
	@Autowired
	public void TwilioInitiazer(Twilioproperties twilioproperties)
	{
		this.twilioproperties=twilioproperties;
		Twilio.init(twilioproperties.getAccountSid(), twilioproperties.getAuthToken());
		System.out.println("Twilio initialized with account-"+twilioproperties.getAccountSid());
	}
}