package com.spring.graphql.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.graphql.model.Product;
import com.spring.graphql.repository.ProductRepository;

@Service
public class ProductDaoImpl implements ProductDao
{
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product product) 
	{
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAll() 
	{
		return (List<Product>) productRepository.findAll();
	}

}
