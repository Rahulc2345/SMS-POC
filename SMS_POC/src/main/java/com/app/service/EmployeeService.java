package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {

	Employee searchById(Integer id);
	String editEmployee(Employee employee);
	String deleteEmployee(Integer id);
	Employee addEmployee(Employee employee);
	List<Employee> employeeList();
}
