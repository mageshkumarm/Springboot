package com.online.smartsilk.shop.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.online.smartsilk.shop.Entity.Order;

@Service
public class OrderService {
	List<Order> newList = new ArrayList<Order>();

	OrderService() {
		newList.add(new Order(1, "Order1"));
		newList.add(new Order(2, "Order2"));
		newList.add(new Order(3, "Order3"));
	}

	public List<Order> getOrderDetails() {
		// List<Order> orderList = Arrays.asList(new Order(1, "Order1"), new Order(2,
		// "Order2"), new Order(3, "Order3"));

		return newList;
	}

}
