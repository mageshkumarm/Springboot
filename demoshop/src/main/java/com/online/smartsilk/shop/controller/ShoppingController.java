package com.online.smartsilk.shop.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.online.smartsilk.shop.Entity.Order;
import com.online.smartsilk.shop.Entity.ProductDetail;
import com.online.smartsilk.shop.service.OrderService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ShoppingController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/home")
	public String welcomeMsg() {
		return "Welcome to Spring boot";
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Order> readAllOrder() {

		return orderService.getOrderDetails();
	}

	@RequestMapping("/orders/{id}")
	public List<Order> getOrderList(@PathVariable int id) {
		return orderService.getOrderDetails().stream().filter(p -> p.getOrderId() == id).collect(Collectors.toList());
	}

	@RequestMapping(value = "/orders", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> save(@RequestBody Order ord) {

		// List<Order> lists = new ArrayList<Order>();
		int oldSize = orderService.getOrderDetails().size();

		System.out.println("Old count :" + oldSize + "->ID = " + ord.getOrderId() + ", Orders" + ord.getNumOfOrder());

		// orderService.getOrderDetails().add(ord);
		orderService.getOrderDetails().add(ord);

		int newSize = orderService.getOrderDetails().size();
		System.out.println("New count :" + newSize);
		if (newSize > oldSize) {
			System.out.println("OK");
			return new ResponseEntity<Order>(ord, HttpStatus.OK);

		}

		System.out.println("NO_CONTENT");
		return new ResponseEntity<Order>(ord, HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Order> remove(@PathVariable int id) {
		orderService.getOrderDetails().remove(id);
		return new ResponseEntity<Order>(HttpStatus.OK);
	}

	@RequestMapping(value = "/bill/{id}", method = RequestMethod.GET)
	public String generateBill(@PathVariable int id) {
		String url = "http://localhost:8082/api/products/" + id;
		RestTemplate restTemplate = new RestTemplate();
		String pro = restTemplate.getForObject(url, String.class);

		//System.out.println(pro.getOrderID() +"-"+pro.getProductID()+"-"+pro.getProductName()+"-"+pro.getUnits());
		return pro.toString();
	}
}
