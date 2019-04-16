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
	@RequestMapping(value = "/addbill", method = RequestMethod.POST,   produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	   @ResponseBody()
	   public Bill addNewBill(@RequestBody Bill bill) {
	       return this.billService.addBill(bill);
 }
}
