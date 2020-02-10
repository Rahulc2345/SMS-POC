package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public Employee searchById(Integer id) {
		Employee e=(Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
		System.out.println(e.getDocuments().size());
		return e;
	}


	@Override
	public String editEmployee(Employee employee) {
		 sessionFactory.getCurrentSession().update(employee);
		 return "Employee with id "+employee.getId()+ " updated";
	}


	@Override
	public String deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().delete(employee);
		return "Employee with id "+employee.getId()+ " deleted";
	}


	@Override
	public Employee addEmployee(Employee employee) {
		System.out.println(employee.getDocuments());
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
		return employee;
	}


	@Override
	public List<Employee> employeeList() {
		return sessionFactory.getCurrentSession().createCriteria(Employee.class, "select e from Employee e join fetch e.documents").list();
	}
	
	
}
