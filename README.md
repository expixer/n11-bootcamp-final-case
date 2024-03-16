Restaurant Reviews App
=======================
This is a restaurant reviews app that allows users to view restaurants and their reviews. Users can also add new restaurants and reviews. The app is built using the Java Spring Boot framework and uses a Postgresql database to store the data.

## Installation
1. Clone the repository
2. Open the project in your IDE
3. Run this command to install the dependencies
```bash
cd user-restaurant-review && docker compose up -d
```
4. Run the project(if you dont need the dummy solr data, you can delete the data folder in the root directory)
5. Request the API endpoints using Postman or any other API testing tool
( You can also use the Swagger UI to test the API endpoints by visiting this URL: http://localhost:8080/swagger-ui/index.html)

## API Endpoints
The following are the API endpoints that can be used to interact with the app:

### Customers
- GET /customers - Get all customers
- GET /customers/{id} - Get a customer by id
- POST /customers - Add a new customer
- PUT /customers/{id} - Update a customer
- DELETE /customers/{id} - Delete a customer
- PATCH /customers/{id} - Update a customer's password

### Restaurants
- GET /restaurants - Get all restaurants
- GET /restaurants/{id} - Get a restaurant by id
- POST /restaurants - Add a new restaurant
- PUT /restaurants/{id} - Update a restaurant
- DELETE /restaurants/{id} - Delete a restaurant

### Reviews
- GET /restaurants/{restaurantId}/reviews - Get all reviews for a restaurant
- GET /restaurants/{restaurantId}/reviews/{id} - Get a review by id
- POST /restaurants/{restaurantId}/reviews - Add a new review
- PUT /restaurants/{restaurantId}/reviews/{id} - Update a review
- DELETE /restaurants/{restaurantId}/reviews/{id} - Delete a review

### Recommendations
- GET /restaurants/recommendations/{id} - Get recommended restaurants

## Technologies
- Java
- Spring Boot
- Postgresql
- Docker
- Swagger
- Maven
- Apache Solr
