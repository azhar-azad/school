package com.azad.practice.school.io.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class CourseEntity implements Serializable {

	private static final long serialVersionUID = 3313849886976937022L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String courseId;

	@Column(nullable = false, unique = true)
	private String code;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String fullName;

	@Column(nullable = false)
	private double credit;

	@Column(nullable = false)
	private double creditHour;

	@OneToMany(mappedBy = "courseEntity")
	private List<ReviewEntity> reviewEntityList;

	protected CourseEntity() {
		super();
	}

	public CourseEntity(String courseId, String code, String name, String fullName, double credit, double creditHour) {
		super();
		this.courseId = courseId;
		this.code = code;
		this.name = name;
		this.fullName = fullName;
		this.credit = credit;
		this.creditHour = creditHour;
	}

	public Long getId() {
		return id;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double getCreditHour() {
		return creditHour;
	}

	public void setCreditHour(double creditHour) {
		this.creditHour = creditHour;
	}

	public List<ReviewEntity> getReviewEntityList() {
		return reviewEntityList;
	}

	public void setReviewEntityList(List<ReviewEntity> reviewEntityList) {
		this.reviewEntityList = reviewEntityList;
	}

}
