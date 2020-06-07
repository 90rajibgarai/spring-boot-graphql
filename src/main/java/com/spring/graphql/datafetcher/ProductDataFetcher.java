package com.spring.graphql.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.graphql.exception.ResourceNotFoundException;
import com.spring.graphql.model.Product;
import com.spring.graphql.repository.ProductRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ProductDataFetcher implements DataFetcher<Product>
{
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product get(DataFetchingEnvironment environment) 
	{
		String id = environment.getArgument("id");
		
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
	}

}
