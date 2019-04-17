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

import com.lab.software.engineering.businesstriporder.entity.TravelOrder;
import com.lab.software.engineering.businesstriporder.service.TravelOrderService;
 

@RestController
@RequestMapping("/api")
public class TravelOrderRestController {
	
	@Autowired
	private TravelOrderService travelOrderService;
	
	
	@GetMapping("/travelorders")
	public List<TravelOrder> findAll(){
		return travelOrderService.findAll();
	}

	@RequestMapping(value = "/addtravelorder", method = RequestMethod.POST,   produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	   @ResponseBody()
	   public TravelOrder addNewVehicle(@RequestBody TravelOrder travelOrder) {
	       return this.travelOrderService.addTravelOrder(travelOrder);
    }
	
	
}
