package com.online.smartsilk.shop.Entity;

import javax.xml.bind.annotation.XmlRootElement;

public class Order {

	private int orderId;
	private String numOfOrder;

	public Order() {

	}

	public Order(int orderId, String numOfOrder) {
		super();
		this.orderId = orderId;
		this.numOfOrder = numOfOrder;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getNumOfOrder() {
		return numOfOrder;
	}

	public void setNumOfOrder(String numOfOrder) {
		this.numOfOrder = numOfOrder;
	}

}
