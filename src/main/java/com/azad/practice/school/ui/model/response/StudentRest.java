package com.azad.practice.school.ui.model.response;

import java.util.Date;

public class StudentRest {

	private String studentId;
	private String name;
	private String email;
	private Date birthDate;
	private String passportNumber;

	public StudentRest() {
		super();
	}

	public StudentRest(String studentId, String name, String email, Date birthDate) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

}
