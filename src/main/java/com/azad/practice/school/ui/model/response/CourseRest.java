package com.azad.practice.school.ui.model.response;

public class CourseRest {

	private String courseId;
	private String code;
	private String name;
	private String fullName;
	private double credit;
	private double creditHour;

	protected CourseRest() {
		super();
	}

	public CourseRest(String courseId, String code, String name, String fullName, double credit, double creditHour) {
		super();
		this.courseId = courseId;
		this.code = code;
		this.name = name;
		this.fullName = fullName;
		this.credit = credit;
		this.creditHour = creditHour;
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
