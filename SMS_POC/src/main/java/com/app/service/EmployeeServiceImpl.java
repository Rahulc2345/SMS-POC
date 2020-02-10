package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;

@Service("empservice")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	
	@Override
	public Employee searchById(Integer id) {
		return dao.searchById(id);
	}


	@Override
	public String editEmployee(Employee employee) {
		return dao.editEmployee(employee);
	}


	@Override
	public String deleteEmployee(Integer id) {
		Employee e=dao.searchById(id);
		return dao.deleteEmployee(e);
	}



	@Override
	public List<Employee> employeeList() {
		// TODO Auto-generated method stub
		return dao.employeeList();
	}


	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.addEmployee(employee);
	}

}
