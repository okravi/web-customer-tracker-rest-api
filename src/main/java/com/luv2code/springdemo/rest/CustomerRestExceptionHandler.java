package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	//add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
		
		//create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(
				HttpStatus.NOT_FOUND.value(), 
				exc.getMessage(), 
				System.currentTimeMillis());
		
		//return response entity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//add exception handler for all the other exceptions
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){
		
		//create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(
				HttpStatus.BAD_REQUEST.value(), 
				exc.getMessage(), 
				System.currentTimeMillis());
		
		//return response entity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
}
