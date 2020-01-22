package com.azad.practice.school.exception;

import java.io.Serializable;

public class StudentServiceException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 3986731080097716266L;

	public StudentServiceException(String message) {
		super(message);
	}

	
}
