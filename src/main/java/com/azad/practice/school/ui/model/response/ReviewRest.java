package com.azad.practice.school.ui.model.response;

public class ReviewRest {

	private String reviewId;
	private double rating;
	private String description;
	private String courseCode;

	protected ReviewRest() {
		super();
	}

	public ReviewRest(String reviewId, double rating, String description) {
		super();
		this.reviewId = reviewId;
		this.rating = rating;
		this.description = description;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
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
