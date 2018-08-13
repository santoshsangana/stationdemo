package com.sangana.stationdemo.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlingController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneralException(Exception e)  throws Exception {
		
		ErrorResponse response = new ErrorResponse();
		
		response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(e.getMessage());
		System.out.println("Executing handleGeneralException !!!");
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e)  throws Exception {
		
		ErrorResponse response = new ErrorResponse();
		
		response.setCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase() + e.getMessage());
		System.out.println("Executing handleCustomException !!!");
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}

}
