package com.azad.practice.school.ui.model.request;

public class PassportDetailsRequestModel {

	private String number;
	private String studentEmail;

	public PassportDetailsRequestModel() {
		super();
	}

	public PassportDetailsRequestModel(String number) {
		super();
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

}
