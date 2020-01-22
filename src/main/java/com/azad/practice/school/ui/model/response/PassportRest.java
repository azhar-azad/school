package com.azad.practice.school.ui.model.response;

public class PassportRest {

	private String passportId;
	private String number;
	private String studentName;

	protected PassportRest() {
		super();
	}

	public PassportRest(String passportId, String number) {
		super();
		this.passportId = passportId;
		this.number = number;
	}

	public String getPassportId() {
		return passportId;
	}

	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	
}
