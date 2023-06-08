package com.sanjeet.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjeet.ecommerce.entity.Product;
import com.sanjeet.ecommerce.repository.ProductRepositoy;

import lombok.extern.slf4j.Slf4j;

//@Slf4j
@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductRepositoy productRepositoy;
	
	@GetMapping("products")
	public List<Product> getAllProduct(){
		return productRepositoy.findAll();
	}
	
}
