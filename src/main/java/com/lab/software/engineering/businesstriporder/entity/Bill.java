package com.lab.software.engineering.businesstriporder.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the BILL database table.
 * 
 */
@Entity
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="BILL_NUM")
	private BigDecimal billNum;

	@Column(name="IMG_PATH")
	private String imgPath;

	@Column(name="\"SUM\"")
	private BigDecimal sum;

	//bi-directional many-to-one association to TravelOrder
	@ManyToOne
	@JoinColumn(name="TRAVEL_ORDER_ID")
	private TravelOrder travelOrder;

	public Bill() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getBillNum() {
		return this.billNum;
	}

	public void setBillNum(BigDecimal billNum) {
		this.billNum = billNum;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public BigDecimal getSum() {
		return this.sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}

	public TravelOrder getTravelOrder() {
		return this.travelOrder;
	}

	public void setTravelOrder(TravelOrder travelOrder) {
		this.travelOrder = travelOrder;
	}

}