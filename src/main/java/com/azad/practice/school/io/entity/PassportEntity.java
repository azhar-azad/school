package com.azad.practice.school.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passport")
public class PassportEntity implements Serializable {

	private static final long serialVersionUID = -3563063091484613704L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String passportId;
	
	@Column(nullable = false, unique = true)
	private String number;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passportEntity")
	private StudentEntity studentEntity;

	protected PassportEntity() {
		super();
	}

	public PassportEntity(String passportId, String number) {
		super();
		this.passportId = passportId;
		this.number = number;
	}

	public Long getId() {
		return id;
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

	public StudentEntity getStudentEntity() {
		return studentEntity;
	}

	public void setStudentEntity(StudentEntity studentEntity) {
		this.studentEntity = studentEntity;
	}

}
