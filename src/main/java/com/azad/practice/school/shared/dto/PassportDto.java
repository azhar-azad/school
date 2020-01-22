package com.azad.practice.school.shared.dto;

public class PassportDto {

	private Long id;
	private String passportId;
	private String number;
	private String studentEmail;

	protected PassportDto() {
		super();
	}

	public PassportDto(String number) {
		this.number = number;
	}

	public PassportDto(String passportId, String number) {
		super();
		this.passportId = passportId;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

}
