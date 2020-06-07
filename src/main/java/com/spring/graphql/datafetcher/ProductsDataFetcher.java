package com.spring.graphql.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.graphql.model.Product;
import com.spring.graphql.repository.ProductRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ProductsDataFetcher implements DataFetcher<List<Product>>
{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> get(DataFetchingEnvironment environment)
	{
		return productRepository.findAll();
	}
}
