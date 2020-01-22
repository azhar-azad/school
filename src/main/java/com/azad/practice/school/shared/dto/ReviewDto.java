package com.azad.practice.school.shared.dto;

public class ReviewDto {

	private Long id;
	private String reviewId;
	private double rating;
	private String description;
	private String courseCode;

	protected ReviewDto() {
		super();
	}

	public ReviewDto(Long id, String reviewId, double rating, String description) {
		super();
		this.id = id;
		this.reviewId = reviewId;
		this.rating = rating;
		this.description = description;
	}

	public Long getId() {
		return id;
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
