package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookingDetails;
import com.example.demo.repository.BookingRepository;


@Service
public class BookingServiceImpl implements BookingService{
	@Autowired
	private BookingRepository bookingRepository;


	@Override
	public List<BookingDetails> getAllBookingDetailss() {
		return bookingRepository.findAll();
	}

	@Override
	public void saveBookingDetails(BookingDetails bookingDetails) {
		this.bookingRepository.save(bookingDetails);
		
	}

	@Override
	public BookingDetails getBookingDetailsById(String Username) {
		Optional<BookingDetails> optional=bookingRepository.findById(Username);
		BookingDetails bookingDetails=null;
		if(optional.isPresent())
			bookingDetails=optional.get();
		else
			throw new RuntimeException("Booking Details Not Found for Username :: "+Username);
		return bookingDetails;
	}
	
	@Override
	public void deleteBookingById(String Name) {
		this.bookingRepository.deleteById(Name);
	}

}
