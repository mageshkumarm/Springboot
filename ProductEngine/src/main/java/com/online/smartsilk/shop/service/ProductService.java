package com.online.smartsilk.shop.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.online.smartsilk.shop.entity.ProductDetail;

@Service
public class ProductService {
	
	public List<ProductDetail> getProductList()
	{
		return Arrays.asList(
				new ProductDetail(1,1,"Product1",2520, 2),
				new ProductDetail(1,2,"Product1",2352, 2),
				new ProductDetail(2,3,"Product1",343, 3),
				new ProductDetail(2,4,"Product1",4535, 1));
	}

}
