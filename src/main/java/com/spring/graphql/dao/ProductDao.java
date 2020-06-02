package com.spring.graphql.dao;

import java.util.List;

import com.spring.graphql.model.Product;

public interface ProductDao
{
	public Product saveProduct(Product product);

	public List<Product> getAll();

}
