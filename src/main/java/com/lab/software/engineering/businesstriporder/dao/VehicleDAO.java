package com.lab.software.engineering.businesstriporder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.software.engineering.businesstriporder.entity.Vehicle;

public interface VehicleDAO extends JpaRepository<Vehicle, Integer> {

	
}
