package com.lab.software.engineering.businesstriporder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.software.engineering.businesstriporder.dao.BillDAO;
import com.lab.software.engineering.businesstriporder.entity.Bill;

@Service
public class BillService {
	
	@Autowired
	private BillDAO billDao;

	
	public List<Bill> findAll(){
		return billDao.findAll();
		
	}
}
