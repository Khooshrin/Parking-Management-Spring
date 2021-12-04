package com.example.demo.service;

import java.util.List;

import com.example.demo.model.BookingDetails;

public interface BookingService {

	List<BookingDetails> getAllBookingDetailss();
	void saveBookingDetails(BookingDetails bookingDetails);
	BookingDetails getBookingDetailsById(String Username);
	void deleteBookingById(String Name);
	
}
