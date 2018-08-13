package com.sangana.stationdemo.errorhandling;

import org.springframework.stereotype.Component;

@Component
public class ErrorResponse {
	
	int code;
	String message;

	public ErrorResponse() {
		super();
	}
	
	public ErrorResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
