package com.lab.software.engineering.businesstriporder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import com.lab.software.engineering.businesstriporder.dao.EmployeeDAO;
import com.lab.software.engineering.businesstriporder.entity.Employee; 

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;
	 
	public List<Employee> findAll() {
		return employeeDao.findAll();
	} 
 
	public Employee addEmployee(Employee employee) { 
		return this.employeeDao.save(employee);		
	}
	
	
}
