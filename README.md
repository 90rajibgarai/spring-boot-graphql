# Spring Boot GraphQL

What is GraphQL ? 
-----------------
GraphQL is an open-source query language. It gives control to the user to query what he needs. That means using graphql we can avoid the problem of to over fetching and under fetching of the data thrugh REST API.

* GraphQL works on top of the REST API. 
* GraphQL was developed by Facebook for developing own Facebook mobile applications.

REST vs GraphQL : 
-----------------
(A) Network Performance:

When UI invokes a REST API, it will not have any control over the response data, whereas GraphQL provides a mechanism to specify the fields of interest in response. 
This reduces network overload by fetching the smallest data possible.
	
(B) Endpoint: 	

In REST, each resource is identified by a URI. This makes the client obliged to know each endpoint. In GraphQL, all resources are identified by a single endpoint. 
There is no hassle of maintaining multiple URI’s.
	
(C) Data Fetching Strategy: 

In GraphQL, we have only one endpoint. The client sends a single query with the required fields. This helps with improved network performance and avoids the over-fetching/under-fetching data problem.

* GraphQL is not replacement for REST both are coexist. You need used the corresponding technology whereever it make sense for you.

The main terms used most commonly in GraphQL are:

* Schema — The contract between the GraphQL client and the GraphQL server
* Query — Similar to GET call in REST and used by the client to query the fields
* Mutations — It is similar to a POST/PUT call in REST and is used by the client for any insert/update operation

Limitations :

1) The nested queries having multiple fields could lead to performance issues. GraphQL queries has to be carefully designed as the control is with client and it could ask anything.

2) Web caching is easier with REST compared to GraphQL, as the latter has a single endpoint.

3) Retrieving objects recursively (to infinite length) is not supported in GraphQL. One has to specify to what depth it needs the data to get the recursive data.
	
Though GraphQL is becoming popular, it is not always the best choice, and it is not the alternative for REST web services. 
REST has its own advantages over GraphQL in terms of web cache, performance, etc.

NOTE :
------
1) REST is an Architectural Style. Where as GraphQL is a Framework or Query Language. Base on the query your data will be changed.
2) In REST URL will be change for different endpoints. But In GraphQL it need not be changed.
3) Both are work on HTTP. REST support number of HTTP Method like : GET, POST, PUT, PATCH, DELETE etc. But GraphQL only support POST method.
4) Since REST provides a static endpoint we can't change the response base on our needs. So Over fetching/Under fetching  data are available.
On the GraphQL we change the response base on our needs. GraphQL do on server-side filtering resolvers.

Official Link of GraphQL :
-------------------------------------------------------------------------------------------------------------------------------------

http://howtographql.com/

Architectural - Uses Cases-1
-------------------------------------------------------------------------------------------------------------------------------------

<img src="https://github.com/90rajibgarai/doc-important-links/blob/master/Architectures/GraphQL-Usecases/Usecase-1.png">

Architectural - Uses Cases-2
------------------------------------------------------------------------------------------------------------------------------------

<img src="https://github.com/90rajibgarai/doc-important-links/blob/master/Architectures/GraphQL-Usecases/Usecase-2.png">

Architectural - Uses Cases-3
------------------------------------------------------------------------------------------------------------------------------------

<img src="https://github.com/90rajibgarai/doc-important-links/blob/master/Architectures/GraphQL-Usecases/Usecase-3.png">

------------------------------------------------------------------------------------------------------------------------------------
Application output :
------------------------------------------------------------------------------------------------------------------------------------
Example-1 :

-----------------------------------------------------------------------------------------------------------------------------------
* Requested URI : http://localhost:9090/products
* HTTP Method : POST
* Requested Body : 

		query 
		{
		  product(id: "5ed5e7df6c8db5464d148a23") 
		  {
			    id, 
			    name,
			    price,
			    imageUrl,
			    dateAdded
		  }
		}	
* Requested Output :

		{
		    "errors": [],
		    "data": {
			"product": {
			    "id": "5ed5e7df6c8db5464d148a23",
			    "name": "Samsung S20",
			    "price": 77999.0,
			    "imageUrl": [
				"https://amzn.to/2ZXeGqb",
				"https://amzn.to/2Bp0ex8",
				"https://amzn.to/2yYwjem"
			    ],
			    "dateAdded": "2020-06-02T11:17:11.833"
			}
		    },
		    "extensions": null,
		    "dataPresent": true
		}
---------------------------------------------------------------------------------------------------------------------------------
Example-2 :
---------------------------------------------------------------------------------------------------------------------------------

* Requested URI : http://localhost:9090/products
* HTTP Method : POST
* Requested Body : 

		query 
		{
		  allProducts
		  {
			    id, 
			    name,
			    price,
			    imageUrl,
			    dateAdded,
				category{
					id,
					name
				}
		  }
		}
		
Requested Output :

	{
	    "errors": [],
	    "data": {
		"allProducts": [
		    {
			"id": "5ed5e7df6c8db5464d148a21",
			"name": "Samsung M31",
			"price": 14999.0,
			"imageUrl": [
			    "https://amzn.to/2Bp0ex8",
			    "https://amzn.to/2AvocGB"
			],
			"dateAdded": "2020-06-02T11:17:11.833",
			"category": {
			    "id": 23,
			    "name": "Mobile"
			}
		    },
		    {
			"id": "5ed5e7df6c8db5464d148a22",
			"name": "Samsung M30",
			"price": 12999.0,
			"imageUrl": [
			    "https://amzn.to/2AvocGB",
			    "https://amzn.to/2Bp0ex8"
			],
			"dateAdded": "2020-06-02T11:17:11.833",
			"category": {
			    "id": 23,
			    "name": "Mobile"
			}
		    },
		    {
			"id": "5ed5e7df6c8db5464d148a23",
			"name": "Samsung S20",
			"price": 77999.0,
			"imageUrl": [
			    "https://amzn.to/2ZXeGqb",
			    "https://amzn.to/2Bp0ex8",
			    "https://amzn.to/2yYwjem"
			],
			"dateAdded": "2020-06-02T11:17:11.833",
			"category": {
			    "id": 23,
			    "name": "Mobile"
			}
		    },
		    {
			"id": "5ed5e7df6c8db5464d148a24",
			"name": "Samsung A71",
			"price": 32998.0,
			"imageUrl": [
			    "https://amzn.to/2yYwjem",
			    "https://amzn.to/2AvocGB"
			],
			"dateAdded": "2020-06-02T11:17:11.833",
			"category": {
			    "id": 23,
			    "name": "Mobile"
			}
		    },
		    {
			"id": "5ed5e7df6c8db5464d148a25",
			"name": "Apple iPhone 11",
			"price": 68300.0,
			"imageUrl": [
			    "https://amzn.to/3gNb9AL",
			    "https://amzn.to/3dvQ38g"
			],
			"dateAdded": "2020-06-02T11:17:11.833",
			"category": {
			    "id": 23,
			    "name": "Mobile"
			}
		    },
		    {
			"id": "5ed5e7df6c8db5464d148a26",
			"name": "Apple iPhone 11 Pro",
			"price": 106600.0,
			"imageUrl": [
			    "https://amzn.to/3eKB61Z",
			    "https://amzn.to/2TVrLN5"
			],
			"dateAdded": "2020-06-02T11:17:11.833",
			"category": {
			    "id": 23,
			    "name": "Mobile"
			}
		    },
		    {
			"id": "5ed5e7df6c8db5464d148a27",
			"name": "Apple iPhone XR ",
			"price": 49900.0,
			"imageUrl": [
			    "https://amzn.to/2U0qAf7",
			    "https://amzn.to/2MlqWca",
			    "https://amzn.to/2Mkbi0D"
			],
			"dateAdded": "2020-06-02T11:17:11.833",
			"category": {
			    "id": 23,
			    "name": "Mobile"
			}
		    },
		    {
			"id": "5ed5e7df6c8db5464d148a28",
			"name": "OnePlus 7T Pro",
			"price": 47999.0,
			"imageUrl": [
			    "https://amzn.to/2MqHDCR"
			],
			"dateAdded": "2020-06-02T11:17:11.833",
			"category": {
			    "id": 23,
			    "name": "Mobile"
			}
		    },
		    {
			"id": "5ed5e7df6c8db5464d148a29",
			"name": "Moto G6",
			"price": 12990.0,
			"imageUrl": [
			    "https://amzn.to/3gNeUpR"
			],
			"dateAdded": "2020-06-02T11:17:11.833",
			"category": {
			    "id": 23,
			    "name": "Mobile"
			}
		    }
		]
	    },
	    "extensions": null,
	    "dataPresent": true
	}
-------------------------------------------------------------------------------------------------------------------------------------

Postman view :

<img src="https://github.com/90rajibgarai/doc-important-links/blob/master/Architectures/GraphQL-Usecases/Postman_Output.png">
