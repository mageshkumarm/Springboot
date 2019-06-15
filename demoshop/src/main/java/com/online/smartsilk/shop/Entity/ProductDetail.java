package com.online.smartsilk.shop.Entity;

public class ProductDetail {
	private int orderID;
	private int productID;
	private String productName;
	private double price;
	private int units;
	
	
	
	public ProductDetail(int orderID, int productID, String productName, double price, int units) {
		super();
		this.orderID = orderID;
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.units = units;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	

}
