package com.online.smartsilk.shop.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.online.smartsilk.shop.entity.ProductDetail;
import com.online.smartsilk.shop.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//get product detail
	@RequestMapping("/products")
	public List<ProductDetail> getProductDetails()
	{
		return productService.getProductList();
	}
	
	//update product detail
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public List<ProductDetail> findByOrderID(@PathVariable  int id)
	{
		return productService.getProductList().stream().filter(p -> p.getOrderID() == id).collect(Collectors.toList());
	}
	
	//remove product detail
	

}
