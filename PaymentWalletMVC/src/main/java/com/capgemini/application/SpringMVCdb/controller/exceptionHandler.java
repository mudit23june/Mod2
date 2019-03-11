package com.capgemini.application.SpringMVCdb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.application.SpringMVCdb.exception.DuplicatePhoneNo;
import com.capgemini.application.SpringMVCdb.exception.PhoneNoDoesNotExist;

@ControllerAdvice
public class exceptionHandler
{
	@ExceptionHandler(value=DuplicatePhoneNo.class)
	public ResponseEntity<Object> duplicate(DuplicatePhoneNo ex)
	{
		return new ResponseEntity<>("Exception DUPLICATE",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=PhoneNoDoesNotExist.class)
	public ResponseEntity<Object> notExist(PhoneNoDoesNotExist ex)
	{
		return new ResponseEntity<>("Exception Not Exist",HttpStatus.NOT_FOUND);
	}
}
