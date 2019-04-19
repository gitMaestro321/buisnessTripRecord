package com.lab.software.engineering.businesstriporder.service;

import java.util.List;
import java.util.Optional;

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
	
	/**
	 * Insert new bill for trade order
	 * @param bill
	 * @return added bill
	 */
	public Bill save(Bill bill) {
		return billDao.save(bill);
	}
	
	/**
	 * Update one bil
	 * @param bill
	 * @return
	 */
	public Bill updatebill(Bill bill) {
		Optional<Bill> oneBill = billDao.findById((int)bill.getId());
		return billDao.save(oneBill.get());
	}
	

}
