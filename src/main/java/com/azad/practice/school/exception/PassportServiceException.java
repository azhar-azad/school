package com.azad.practice.school.exception;

import java.io.Serializable;

public class PassportServiceException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -4296669407711490605L;

	public PassportServiceException(String message) {
		super(message);
	}
	
	
}
