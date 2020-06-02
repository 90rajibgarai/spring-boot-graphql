package com.spring.graphql.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "product")
@Data @NoArgsConstructor @AllArgsConstructor
public class Product 
{
	@Id
	private String id;
	
	private String name;
	
	private Category category;
		
	private Company company;
	
	private Double price;
	
	private List<String> imageUrl;
	
	private LocalDateTime dateAdded;

	public Product(String name, Category category, Company company, Double price, List<String> imageUrl,
			LocalDateTime dateAdded) {
		super();
		this.name = name;
		this.category = category;
		this.company = company;
		this.price = price;
		this.imageUrl = imageUrl;
		this.dateAdded = dateAdded;
	}
}
