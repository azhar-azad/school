package com.azad.practice.school.io.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity implements Serializable {

	private static final long serialVersionUID = 6195718076608200373L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String studentId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column
	private Date birthDate;
	
	@OneToOne(fetch = FetchType.LAZY)
	private PassportEntity passportEntity;

	public StudentEntity() {
		super();
	}

	public StudentEntity(String studentId, String name, String email, Date birthDate) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
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

	public PassportEntity getPassportEntity() {
		return passportEntity;
	}

	public void setPassportEntity(PassportEntity passportEntity) {
		this.passportEntity = passportEntity;
	}
	
	

}
