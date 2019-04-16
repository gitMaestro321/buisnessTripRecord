package com.lab.software.engineering.businesstriporder.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.software.engineering.businesstriporder.dao.VehicleDAO;
import com.lab.software.engineering.businesstriporder.entity.Vehicle;

@Service
public class VehicleServiceImplement implements VehicleService {
	
	@Autowired
	private VehicleDAO vehicleDao;
	

	@Override
	public List<Vehicle> findAll() {
	
		return vehicleDao.findAll();
	}


	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		vehicle.setIsActive(true);
		vehicle.setIsAvailable(true);
		return this.vehicleDao.save(vehicle);		
	}



}
