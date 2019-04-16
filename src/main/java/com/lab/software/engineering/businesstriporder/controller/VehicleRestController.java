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

import com.lab.software.engineering.businesstriporder.entity.Vehicle;
import com.lab.software.engineering.businesstriporder.service.VehicleService;

@RestController
@RequestMapping("/api")
public class VehicleRestController {
	
	@Autowired
	private VehicleService vehicleService;
	
	
	@GetMapping("/vehicles")
	public List<Vehicle> findAll(){
		return vehicleService.findAll();
	}

	@RequestMapping(value = "/addvehicle", method = RequestMethod.POST,   produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	   @ResponseBody()
	   public Vehicle addNewVehicle(@RequestBody Vehicle vehicle) {
	       return this.vehicleService.addVehicle(vehicle);
    }
	
	
	
	
	
	
}
