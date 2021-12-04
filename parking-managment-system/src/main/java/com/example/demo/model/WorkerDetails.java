package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="workers")
public class WorkerDetails {

	@Column(name="Rating")
	private int Rating;
	@Column(name="Comments")
	private String Comments;
	@Id
	@Column(name="Name")
	private String Name;
	@Column(name="Hours")
	private int Hours;
	
	public int getHours() {
		return Hours;
	}
	public void setHours(int hours) {
		Hours = hours;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
}