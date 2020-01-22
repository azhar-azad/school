package com.azad.practice.school.shared.dto;

public class CourseDto {

	private Long id;
	private String courseId;
	private String code;
	private String name;
	private String fullName;
	private double credit;
	private double creditHour;

	protected CourseDto() {
		super();
	}

	public CourseDto(String code) {
		super();
		this.code = code;
	}

	public CourseDto(Long id, String courseId, String code, String name, String fullName, double credit,
			double creditHour) {
		super();
		this.id = id;
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

	public void setId(Long id) {
		this.id = id;
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

}
