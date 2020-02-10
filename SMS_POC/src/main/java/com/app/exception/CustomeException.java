package com.app.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomeException{


	@ExceptionHandler(EmployeeNotFoundException.class)
	public String handleEmployeeNotFoundException(Model map){
		//System.out.println("EmpNotFound");
		String ex="Employee cannot be found";
		
		map.addAttribute("exception", ex);
		//System.out.println("EmpNotFound");
		
		return "/employeeView/error";
	}
	
	
	@ExceptionHandler(NullPointerException.class)
	public String handleException(HttpServletRequest req, Model map){
		//System.out.println("handleException");
		String ex="Null pointer Exception";
		//System.out.println(req.getRequestURL());
		map.addAttribute("exception", ex);
		return "/employeeView/error";

	}
}
