package com.lab.software.engineering.businesstriporder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	@RequestMapping(value = "/addtravelorder", method = RequestMethod.PUT,   produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	   @ResponseBody()
	   public TravelOrder addTravelOrder(@RequestBody TravelOrder travelOrder) {
	       return this.travelOrderService.addTravelOrder(travelOrder);
    }
	
	@RequestMapping(value = "/updatetravelorder", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	   public ResponseEntity<?>  setTravelOrderStatus(@RequestBody TravelOrder travelOrder ) {
		    travelOrderService.updateTravelOrder(travelOrder);
		    return  ResponseEntity.ok().body("Travel order has been updated.");
	}  
	
	@GetMapping("/travelorders/created")
	public List<TravelOrder> findAllCreated(){
		return travelOrderService.findAllByStatus("created");
	}
	
	@GetMapping("/travelorders/approved")
	public List<TravelOrder> findAllApproved(){
		return travelOrderService.findAllByStatus("approved");
	}
	
	@GetMapping("/travelorders/refused")
	public List<TravelOrder> findAllRefused(){
		return travelOrderService.findAllByStatus("refused");
	}
	
	@GetMapping("/travelorders/finished")
	public List<TravelOrder> findAllFinished(){
		return travelOrderService.findAllByStatus("finished");
	}
	
	
	
}
