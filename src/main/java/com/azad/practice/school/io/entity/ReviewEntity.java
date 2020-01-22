package com.azad.practice.school.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class ReviewEntity implements Serializable {

	private static final long serialVersionUID = -8512361724873670071L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String reviewId;

	@Column(nullable = false)
	private double rating;

	@Column(nullable = false)
	private String description;

	@ManyToOne
	private CourseEntity courseEntity;

	public ReviewEntity() {
		super();
	}

	public ReviewEntity(String reviewId, double rating, String description) {
		super();
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

	public CourseEntity getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(CourseEntity courseEntity) {
		this.courseEntity = courseEntity;
	}

}
