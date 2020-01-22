package com.azad.practice.school.ui.model.request;

public class ReviewDetailsRequestModel {

	private double rating;
	private String description;
	private String courseCode;

	protected ReviewDetailsRequestModel() {
		super();
	}

	public ReviewDetailsRequestModel(double rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
