package com.spring.graphql.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.spring.graphql.datafetcher.ProductDataFetcher;
import com.spring.graphql.datafetcher.ProductsDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService
{	
	@Autowired
	private ProductDataFetcher productDataFetcher;
	
	@Autowired
	private ProductsDataFetcher productsDataFetcher;
	
	@Value("classpath:products.graphql")
    private Resource resource;
	
	private GraphQL graphQL;
	
	 @PostConstruct
	 private void loadSchema() throws IOException 
	 {
		 File schemaFile = resource.getFile();	// Get The Schema
		 
		 TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile); // Parse Schema
	 
		 RuntimeWiring wiring = buildRuntimeWiring();
		 
		 GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		 
		 graphQL = GraphQL.newGraphQL(schema).build();
	 }
	 
	 private RuntimeWiring buildRuntimeWiring()
	 {
		 return RuntimeWiring.newRuntimeWiring()
				 				.type("Query", typeWiring -> typeWiring
				 						.dataFetcher("allProducts", productsDataFetcher)
				 						.dataFetcher("product", productDataFetcher))
				 				.build();
	 }
	 
	 public GraphQL getGraphQL() 
	 {
	    return graphQL;
	 }
}
