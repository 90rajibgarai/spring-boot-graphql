package com.spring.graphql.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.graphql.dao.ProductDao;
import com.spring.graphql.model.Category;
import com.spring.graphql.model.Company;
import com.spring.graphql.model.Product;

@Service
public class ProductServiceImpl implements ProductService 
{
	@Autowired
	private ProductDao productDao;
	
	
	@Override
	public List<Product> saveDefaultProducts()
	{
		Stream.of(new Product("Samsung M31", new Category(23, "Mobile"), new Company(75, "Samsung"), 14999.00, Arrays.asList("https://amzn.to/2Bp0ex8", "https://amzn.to/2AvocGB"), LocalDateTime.now()),
					new Product("Samsung M30", new Category(23, "Mobile"), new Company(75, "Samsung"), 12999.00, Arrays.asList("https://amzn.to/2AvocGB", "https://amzn.to/2Bp0ex8"), LocalDateTime.now()),
					new Product("Samsung S20", new Category(23, "Mobile"), new Company(75, "Samsung"), 77999.00, Arrays.asList("https://amzn.to/2ZXeGqb", "https://amzn.to/2Bp0ex8", "https://amzn.to/2yYwjem"), LocalDateTime.now()),
					new Product("Samsung A71", new Category(23, "Mobile"), new Company(75, "Samsung"), 32998.00, Arrays.asList("https://amzn.to/2yYwjem", "https://amzn.to/2AvocGB"), LocalDateTime.now()),
					new Product("Apple iPhone 11", new Category(23, "Mobile"), new Company(2, "Apple"), 68300.00, Arrays.asList("https://amzn.to/3gNb9AL", "https://amzn.to/3dvQ38g"), LocalDateTime.now()),
					new Product("Apple iPhone 11 Pro", new Category(23, "Mobile"), new Company(2, "Apple"), 106600.00, Arrays.asList("https://amzn.to/3eKB61Z", "https://amzn.to/2TVrLN5"), LocalDateTime.now()),
					new Product("Apple iPhone XR ", new Category(23, "Mobile"), new Company(2, "Apple"), 49900.00, Arrays.asList("https://amzn.to/2U0qAf7", "https://amzn.to/2MlqWca", "https://amzn.to/2Mkbi0D"), LocalDateTime.now()),
					new Product("OnePlus 7T Pro", new Category(23, "Mobile"), new Company(7, "OnePlus"), 47999.00, Arrays.asList("https://amzn.to/2MqHDCR"), LocalDateTime.now()),
					new Product("Moto G6", new Category(23, "Mobile"), new Company(9, "Moto"), 12990.00, Arrays.asList("https://amzn.to/3gNeUpR"), LocalDateTime.now())).forEach(product -> productDao.saveProduct(product));
		
		return productDao.getAll();
	}

}
