package com.azad.practice.school.ui.model.request;

import java.util.Date;

public class StudentDetailsRequestModel {

	private String name;
	private String email;
	private Date birthDate = new Date();
	private String passportNumber;

	public StudentDetailsRequestModel() {
		super();
	}

	public StudentDetailsRequestModel(String name, String email, Date birthDate, String passportNumber) {
		super();
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.passportNumber = passportNumber;
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
