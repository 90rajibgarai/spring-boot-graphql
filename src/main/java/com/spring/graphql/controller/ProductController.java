package com.spring.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.graphql.model.Product;
import com.spring.graphql.service.GraphQLService;
import com.spring.graphql.service.ProductService;

import graphql.ExecutionResult;

@RestController
@RequestMapping(value = "/products")
public class ProductController
{
	@Autowired
	private ProductService productService;
	
	@Autowired
	private GraphQLService graphQLService;
	
//--------------------------------------------------SAVE SAMPLE PRODUCT-----------------------------------------------------
	@GetMapping("/save/default")
	public List<Product> saveDefaultProducts() 
	{
		return productService.saveDefaultProducts();
	}
	
//--------------------------------------------------GET PRODUCTS-----------------------------------------------------------
	
	@PostMapping()
	public ResponseEntity<Object> getProducts(@RequestBody String query)
	{		
		ExecutionResult execute = graphQLService.getGraphQL().execute(query);
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}
	
	
}
