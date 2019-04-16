package com.lab.software.engineering.businesstriporder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lab.software.engineering.businesstriporder.entity.Employee;
import com.lab.software.engineering.businesstriporder.service.EmployeeService;
 

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	 
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}

	@RequestMapping(value = "/addemployee", method = RequestMethod.POST,   produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	   @ResponseBody()
	   public Employee addNewEmployee(@RequestBody Employee employee) {
	       return this.employeeService.addEmployee(employee);
    }
	
	
}
