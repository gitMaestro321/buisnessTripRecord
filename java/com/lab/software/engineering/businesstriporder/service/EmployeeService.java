package com.lab.software.engineering.businesstriporder.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Employee> findById(long id) {
		return employeeDao.findById(id);
		 
	}
	
	public Employee updateEmployee(int id, Employee emp) {
		   emp.setId(id);
		   this.saveEmployee(emp);
	       return emp;
	}
	
	public void deactivateEmployee(int id) {
		Optional <Employee> emp = this.findById(id);
		emp.get().setIsActive(false);
		this.saveEmployee(emp.get());
	}
	
	public void activateEmployee(int id) {
		Optional <Employee> emp = this.findById(id);
		emp.get().setIsActive(true);
		this.saveEmployee(emp.get());
	}
	 
	public void saveEmployee(Employee emp) {
		employeeDao.save(emp);
	}
	
	
}

