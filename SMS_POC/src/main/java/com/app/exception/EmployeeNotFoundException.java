package com.app.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee Not Found")
public class EmployeeNotFoundException extends Exception{
	
	public EmployeeNotFoundException(int id){
		super("Employee Info with Id "+ id +" Not Found");
	}

}
