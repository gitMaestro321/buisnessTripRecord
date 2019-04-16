package com.lab.software.engineering.businesstriporder.service;

import java.util.List;

import com.lab.software.engineering.businesstriporder.entity.Vehicle;

public interface VehicleService {

	public List<Vehicle> findAll();
	public Vehicle addVehicle(Vehicle vehicle);
		
	}
