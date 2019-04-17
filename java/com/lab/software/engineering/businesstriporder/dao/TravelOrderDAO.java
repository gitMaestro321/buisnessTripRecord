package com.lab.software.engineering.businesstriporder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;  
import com.lab.software.engineering.businesstriporder.entity.TravelOrder; 

@Repository
public interface TravelOrderDAO extends JpaRepository<TravelOrder, Long> {
	
}