package com.robertojr.PROJECT_API_REST.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.robertojr.PROJECT_API_REST.services.exceptions.DataBaseException;
import com.robertojr.PROJECT_API_REST.services.exceptions.IlegalArgumentException;
import com.robertojr.PROJECT_API_REST.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionsHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,HttpServletRequest request){
		
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError se = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(se);
	}

	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBaseError(DataBaseException e, HttpServletRequest request){
		String error = "Data base error! ";
		HttpStatus status = HttpStatus.CONFLICT;
		StandardError er = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(er);
	}
	
	@ExceptionHandler(IlegalArgumentException.class)
	public ResponseEntity<StandardError> ilegalArgumentError(IlegalArgumentException e, HttpServletRequest request){
		String error = "Arguemnt error! ";
		HttpStatus status = HttpStatus.CONFLICT;
		StandardError er = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(er);
	}
}
