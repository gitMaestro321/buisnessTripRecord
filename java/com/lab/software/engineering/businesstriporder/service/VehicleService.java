package com.lab.software.engineering.businesstriporder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.software.engineering.businesstriporder.dao.VehicleDAO;
import com.lab.software.engineering.businesstriporder.entity.Vehicle;

@Service
public class VehicleService {

	@Autowired
	private VehicleDAO vehicleDao;
	 
	public List<Vehicle> findAll() {
		return vehicleDao.findAll();
	} 
 
	public Vehicle addVehicle(Vehicle vehicle) {
		vehicle.setIsActive(true);
		vehicle.setIsAvailable(true);
		return this.vehicleDao.save(vehicle);		
	}
}
