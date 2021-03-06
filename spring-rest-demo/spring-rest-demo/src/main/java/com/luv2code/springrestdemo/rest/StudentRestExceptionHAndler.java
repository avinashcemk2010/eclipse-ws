package com.luv2code.springrestdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHAndler {

	//Add an exception handler
	//this is global to all the controller
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setMessage(exe.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	//Exception handler to catch nay exception
	//this is global to all the controller
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exec) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setMessage(exec.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
