package com.lab.software.engineering.businesstriporder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	/**
	 * Add new vehicle in thr database
	 * 
	 * @params Vehicle vehicle
	 * @return returnscreated vehicle
	 */
	public Vehicle addVehicle(Vehicle vehicle) {
		vehicle.setIsActive(true);
		vehicle.setIsAvailable(true);
		return this.vehicleDao.save(vehicle);
	}

	/**
	 * Save vehicle in database
	 * 
	 * @param vehicle
	 * @return saved vehicle
	 */
	public Vehicle save(Vehicle vehicle) {
		return vehicleDao.save(vehicle);
	}

	/**
	 * Returns vehicle by id
	 * 
	 * @params id
	 * @return returns queried vehicle
	 */
	public Optional<Vehicle> findById(long id) {
		return vehicleDao.findById(id);
	}

	/**
	 * Set vehicle to be available
	 * 
	 * @param vehicle
	 */
	public void setAvailableVehicle(Vehicle vehicle) {
		vehicle.setIsAvailable(true);
	}

	/**
	 * Set vehicle to be unavaliable
	 * 
	 * @param vehicle
	 */
	public void setUnAvailableVehicle(Vehicle vehicle) {
		vehicle.setIsAvailable(true);
		vehicleDao.save(vehicle);
	}

	/**
	 * Simulates deletetions in DB actualy set status isActive to false
	 * 
	 * @param vehicle
	 */
	public void deleteVehicle(long id) {
		Optional<Vehicle> vehicle = vehicleDao.findById(id);
		vehicle.get().setIsActive(false);
		vehicle.get().setIsAvailable(false);
		vehicleDao.save(vehicle.get());

	}

	/**
	 * Simulates undo delete option in DB, actualy set status isActive to false
	 * 
	 * @param vehicle
	 */
	public void undoDeleteVehicle(long id) {
		Optional<Vehicle> vehicle = vehicleDao.findById(id);
		vehicle.get().setIsActive(true);
		vehicle.get().setIsAvailable(true);
		vehicleDao.save(vehicle.get());
	}

	/**
	 * All available vehicles
	 * 
	 * @return list
	 */

	public List<Vehicle> findAllAvailable() {
		List<Vehicle> allVehicles = vehicleDao.findAll();
		List<Vehicle> allAvailableVehicles = new ArrayList<>();

		for (int i = 0; i < allVehicles.size(); i++) {
			if (allVehicles.get(i).getIsAvailable() == true) {
				allAvailableVehicles.add(allVehicles.get(i));
			}
		}
		return allAvailableVehicles;
	}

	/**
	 * Returns ona available vehicles based on status
	 * 
	 * @return
	 */
	public List<Vehicle> findAllUnAvailable() {
		List<Vehicle> allVehicles = vehicleDao.findAll();
		List<Vehicle> allAvailableVehicles = new ArrayList<>();

		for (int i = 0; i < allVehicles.size(); i++) {
			if (allVehicles.get(i).getIsAvailable() == false) {
				allAvailableVehicles.add(allVehicles.get(i));
			}
		}
		return allAvailableVehicles;
	}

}
