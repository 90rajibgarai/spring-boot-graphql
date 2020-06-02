package com.spring.graphql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.graphql.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>
{

}
