package com.lab.software.engineering.businesstriporder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lab.software.engineering.businesstriporder.dao.TravelOrderDAO;
import com.lab.software.engineering.businesstriporder.entity.TravelOrder; 

@Service
public class TravelOrderService {

	@Autowired
	private TravelOrderDAO travelOrderDao;
	 
	public List<TravelOrder> findAll() {
		return travelOrderDao.findAll();
	} 
 
	public TravelOrder addTravelOrder(TravelOrder travelOrder) { 
		return this.travelOrderDao.save(travelOrder);		
	}
	
	public Optional<TravelOrder> findById(long id) {
		return travelOrderDao.findById(id); 
	}
	  
	public void saveTravelOrder(TravelOrder travelOrder) {
		travelOrderDao.save(travelOrder);
	}
	
	public void updateTravelOrder(TravelOrder travelOrder) {
		travelOrderDao.save(travelOrder);  
	}
	
	public List<TravelOrder> findAllByStatus(String status){
		List <TravelOrder> list = travelOrderDao.findAll();
		List<TravelOrder> list2 = new ArrayList<TravelOrder>();
		for(TravelOrder order : list) {
			if (order.getTravelStatus().getName().equals(status)) {
				list2.add(order);
			}
		}
		return list2;
	}
	 
	
	 
	
	
}
