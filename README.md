
# Contact Management System

A Spring Boot application that provides a RESTful API to manage contact information. This includes CRUD operations, search functionality, database seeding, and application monitoring via Spring Boot Actuator.

---

## Features

- Create, read, update, and delete contacts  
- Search contacts by last name  
- Bulk-populate the database with 50+ randomly generated contacts  
- In-memory H2 database  
- Swagger UI for API testing
- Application monitoring and health checks via Spring Boot Actuator.

---

## Tech Stack

- Java 17  
- Spring Boot  
- Maven  
- Spring Data JPA  
- H2 Database  
- Swagger (springdoc-openapi)  
- Java Faker
- Spring Boot Actuator

---

## Getting Started

### Prerequisites  
- Java 17 or newer  
- Maven  

### To Run the App  
1. Open a terminal in the root directory of the project  
2. Run the following command:  
   ```bash
   ./mvnw spring-boot:run
   ```  
3. Or, open the project in your IDE and run `HelloWorldApplication.java`  

---

## API Endpoints

### Swagger UI  
Visit this URL to access the API documentation and test endpoints:  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Contact API Routes  

- `GET /api/contacts` - Retrieve all contacts  
- `GET /api/contacts/{id}` - Retrieve a contact by ID  
- `GET /api/contacts/search?lastName=Smith` - Search for contacts by last name  
- `POST /api/contacts` - Create a new contact  
- `PUT /api/contacts/{id}` - Update a contact by ID  
- `DELETE /api/contacts/{id}` - Delete a contact by ID  

### Populate Route  

- `POST /api/contacts/populate` - Populates the database with 50 random contacts using Java Faker

### Actuator Endpoints

Spring Boot Actuator provides endpoints for monitoring and managing the application. Some commonly used endpoints:

| Endpoint           | Description                              |
|--------------------|------------------------------------------|
| `/actuator/health` | Shows application health status          |
| `/actuator/info`   | Displays custom application info         |
| `/actuator/metrics`| Returns metrics like memory, threads, etc.|

---

## Example JSON for Postman Testing

```json
{
  "firstName": "Jane",
  "lastName": "Doe",
  "phone": "555-123-4567",
  "email": "jane.doe@example.com"
}
```

---

## H2 Database Console

You can view and interact with the in-memory H2 database at this URL:  
[http://localhost:8080/h2-console](http://localhost:8080/h2-console)

Use the following settings:  
- JDBC URL: `jdbc:h2:mem:testdb`  
- Username: `sa`  
- Password: *(leave blank)*
