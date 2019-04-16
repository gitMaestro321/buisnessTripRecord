package com.lab.software.engineering.businesstriporder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.software.engineering.businesstriporder.entity.Bill;
import com.lab.software.engineering.businesstriporder.service.BillService;

@RestController
@RequestMapping("/api")
public class BillRestController {

	@Autowired
	private BillService billService;
	
	@GetMapping("/bills")
	public List<Bill> showAll(){
		return billService.findAll();
	}
}
