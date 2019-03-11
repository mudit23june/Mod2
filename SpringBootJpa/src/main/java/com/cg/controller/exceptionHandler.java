package com.cg.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.exception.DuplicatePhoneNo;
import com.cg.exception.IdDoesNotExist;
import com.cg.exception.NameDoesNotExist;

@ControllerAdvice
public class exceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(value=DuplicatePhoneNo.class)
	public ResponseEntity<Object> duplicate(DuplicatePhoneNo ex)
	{
		return new ResponseEntity<>("The given number already exists",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=IdDoesNotExist.class)
	public ResponseEntity<Object> notExist(IdDoesNotExist ex)
	{
		return new ResponseEntity<>("The given ID does not exist",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=NameDoesNotExist.class)
	public ResponseEntity<Object> nameNotExist(NameDoesNotExist ex)
	{
		return new ResponseEntity<>("Name does not exist",HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
	{
		return new ResponseEntity<>(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
