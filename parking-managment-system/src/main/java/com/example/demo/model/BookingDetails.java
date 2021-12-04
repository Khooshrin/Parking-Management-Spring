package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class BookingDetails {
	@Id
	@Column(name="Username")
	private String Username;
	private int Date;
	private int Month;
	private int Year;
	private int CheckInHour;
	private int CheckInMinute;
	private int CheckOutHour;
	private int CheckOutMinute;
	private String CarWash;
	private String AirFilling;
	
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public int getDate() {
		return Date;
	}
	public void setDate(int date) {
		Date = date;
	}
	public int getMonth() {
		return Month;
	}
	public void setMonth(int month) {
		Month = month;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getCheckInHour() {
		return CheckInHour;
	}
	public void setCheckInHour(int checkInHour) {
		CheckInHour = checkInHour;
	}
	public int getCheckInMinute() {
		return CheckInMinute;
	}
	public void setCheckInMinute(int checkInMinute) {
		CheckInMinute = checkInMinute;
	}
	public int getCheckOutHour() {
		return CheckOutHour;
	}
	public void setCheckOutHour(int checkOutHour) {
		CheckOutHour = checkOutHour;
	}
	public int getCheckOutMinute() {
		return CheckOutMinute;
	}
	public void setCheckOutMinute(int checkOutMinute) {
		CheckOutMinute = checkOutMinute;
	}
	public String getCarWash() {
		return CarWash;
	}
	public void setCarWash(String carWash) {
		CarWash = carWash;
	}
	public String getAirFilling() {
		return AirFilling;
	}
	public void setAirFilling(String airFilling) {
		AirFilling = airFilling;
	}	
	
}
