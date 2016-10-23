package com.mogikanensoftware.json.schema.validation.service;

public class ValidationServiceException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ValidationServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidationServiceException(String message) {
		super(message);
	}

	public ValidationServiceException(Throwable cause) {
		super(cause);
	}

}
