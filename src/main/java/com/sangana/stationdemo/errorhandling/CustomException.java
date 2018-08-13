package com.sangana.stationdemo.errorhandling;

import org.springframework.stereotype.Component;

@Component
public class CustomException extends Exception {

		private static final long serialVersionUID = -6090324744200450622L;

	int code;
	String message;
	
	public CustomException() {
		super();
	}
	
	public CustomException(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public CustomException(String message) {
		super();
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
