package com.azad.practice.school.shared.dto;

import java.util.Date;

public class StudentDto {

	private Long id;
	private String studentId;
	private String name;
	private String email;
	private Date birthDate;
	private String passportNumber;

	public StudentDto() {
		super();
	}

	public StudentDto(Long id, String studentId, String name, String email, Date birthDate, String passportNumber) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.passportNumber = passportNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
