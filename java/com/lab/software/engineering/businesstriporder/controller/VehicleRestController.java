package com.lab.software.engineering.businesstriporder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	// List all vehicles
	@GetMapping("/vehicles")
	public List<Vehicle> findAll() {
		return vehicleService.findAll();
	}

	//Shows vehicle by id 
	@GetMapping("/vehicles/{id}")
	public Optional<Vehicle> getById(@PathVariable("id") long id) {
		return vehicleService.findById(id);
	}
	
	//Add new vehicle
	@RequestMapping(value = "/addvehicle", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody()
	public Vehicle addNewVehicle(@RequestBody Vehicle vehicle) {
		return this.vehicleService.addVehicle(vehicle);
	}

	// Set available status of vehicle on TRUE
	@RequestMapping(value = "/available/{id}", method = RequestMethod.PUT)
	public void setAvailableVehicle(@PathVariable("id") long id) {
		Optional<Vehicle> vehicle = vehicleService.findById(id);
		vehicle.get().setIsAvailable(true);
		vehicleService.save(vehicle.get());
	}

	// Set available status of vehicle on FALSE
	@RequestMapping(value = "/unavailable/{id}", method = RequestMethod.PUT)
	public void setUnAvailableVehicle(@PathVariable("id") long id) {
		Optional<Vehicle> vehicle = vehicleService.findById(id);
		vehicle.get().setIsAvailable(false);
		vehicleService.save(vehicle.get());
	}

	// Simulate deletitions vehicle by id in db, actualy change active and available
	// status
	@RequestMapping(value = "/deletevehicle/{id}", method = RequestMethod.PUT)
	public void deleteVehicle(@PathVariable("id") long id) {
		Optional<Vehicle> vehicle = vehicleService.findById(id);
		vehicleService.deleteVehicle(vehicle.get().getId());
		
	}

	// Simulate undo delete vehicle by id in db, actualy change active and available
	// status
	@RequestMapping(value = "/undeletevehicle/{id}", method = RequestMethod.PUT)
	public void undoDeleteVehicle(@PathVariable("id") long id) {
		Optional<Vehicle> vehicle = vehicleService.findById(id);
		vehicleService.undoDeleteVehicle(vehicle.get().getId());
	}
	
	/**
	 * List of all available vehicles
	 * @return List
	 */
	@GetMapping("/avaliablevehicles")
	public List<Vehicle> findAllAvailable() {
		return vehicleService.findAllAvailable();
	}
	/**
	 * List of all unavailable vehicles
	 * @return List
	 */
	@GetMapping("/unavaliablevehicles")
	public List<Vehicle> findAllUnAvailable() {
		return vehicleService.findAllUnAvailable();
	}
}
