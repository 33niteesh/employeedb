package com.employeedb.jpa.status;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.employeedb.jpa.status.*;
import com.employeedb.jpa.entities.Employee;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> handleEmployeeNotFoundException(NotFoundException ex, WebRequest request){
		String message="Employee not Found with id :"+ex.getId();
		return new  ResponseEntity<>(message,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request){
		String message="Something Wrong:"+ex.getMessage();
		return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
