package com.app.dao;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeDao {

	Employee searchById(Integer id);
	String editEmployee(Employee employee);
	String deleteEmployee(Employee employee);
	Employee addEmployee(Employee employee);
	List<Employee> employeeList();
}
