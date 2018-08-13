package com.sangana.stationdemo.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ExceptionHandler {
	
	public void throwCustomException(String msg) throws CustomException {
		
		CustomException e = new CustomException();
		
		e.setCode(HttpStatus.BAD_REQUEST.value());
		e.setMessage(msg);
		
		throw e;
	}
	
	public void throwGeneralException() throws Exception {
		
		throw new Exception("Error processing request !!!");
	}

}
