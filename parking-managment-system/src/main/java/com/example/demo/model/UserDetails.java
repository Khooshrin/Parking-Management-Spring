package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registrationdetails")
public class UserDetails {
	
	
	@Column(name="Email")
	private String Email;
	@Column(name="FirstName")
	private String FirstName;
	@Column(name="LastName")
	private String LastName;
	@Id
	@Column(name="Username")
	private String Username;
	@Column(name="Phone")
	private String Phone;
	@Column(name="RegNo" )
	private String RegNo;
	@Column(name="Address")
	private String Address;
	@Column(name="Password")
	private String Password;
	private String ConfPassword;
	@Column(updatable=false)
	private String Verify;
	
	public String getVerify() {
		return Verify;
	}
	public void setVerify(String verify) {
		Verify = verify;
	}
	public String getConfPassword() {
		return ConfPassword;
	}
	public void setConfPassword(String confPassword) {
		ConfPassword = confPassword;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getRegNo() {
		return RegNo;
	}
	public void setRegNo(String regNo) {
		RegNo = regNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
}
