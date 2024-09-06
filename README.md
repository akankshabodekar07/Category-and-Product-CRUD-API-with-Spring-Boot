# Category-and-Product-CRUD-API-with-Spring-Boot
This project is a Spring Boot application that provides RESTful APIs for managing categories and products. It allows you to perform CRUD (Create, Read, Update, Delete) operations on a category and product entity using MySql as the database. 

## Prerequisites
* Java 17
* Maven 3.8.8
* MySQL
* Spring Tool Suite 

## API Endpoints
The following CRUD operations are available for the Categories entity:
* Create a Category
  - POST `/api/categories`
  - Request Body:
  ```json
  {
    "name": "CategoryName"
  }

* Get All Category
  - GET `/api/categories`
  
*  Get Category by ID
   -  GET `/api/categories/{id}`

* Update Category
  -  PUT `/api/categories/{id}`
  -  Request Body:
  
  ```json
  {
  "name": "CategoryName"
  }

*   Delete a Category
    - DELETE `/api/categories/{id}`

The following CRUD operations are available for the Products entity:
*  Create a Product
    -  POST `/api/products`
    -  Request Body:
   ```json
    {
      "name": "ProductName",
      "price": 799.99,
      "category": {
        "id": 1
      }
    }

  * Get Product by ID
      - GET `/api/products/{id}`

  * Update a Product
     - PUT `/api/products/{id}`
    -  Request Body:
    ```json
    {
      "name": "ProductName",
      "price": 12999.99,
      "category": {
        "id": 1
      }
    }

*   Delete a Product
  -    DELETE `/api/products/{id}`

## Dependencies
* Spring Boot Starter Data JPA
* Spring Boot DevTools
* Spring Boot Starter Test 
* Spring Boot Starter Web
* Lombok
* MySQL Connector/J
* H2 Database

## Contact
For any issues or inquiries, please contact [akankshabodekar07@gmail.com]





