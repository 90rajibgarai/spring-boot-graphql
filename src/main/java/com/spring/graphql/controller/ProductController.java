package com.spring.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.graphql.model.Product;
import com.spring.graphql.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController
{
	@Autowired
	private ProductService productService;
	
	@GetMapping("/save/default")
	public List<Product> saveDefaultProducts() 
	{
		return productService.saveDefaultProducts();
	}
	
	
}
