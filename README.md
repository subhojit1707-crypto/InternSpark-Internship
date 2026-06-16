# Spring Boot Product API

A RESTful Product Management API built using Spring Boot, Spring Data JPA, Flyway, and H2 Database.

This project was developed as part of a backend development internship assignment and demonstrates:

* CRUD REST API development
* DTO-based request validation
* Database integration with H2
* Flyway database migrations
* Sample data seeding
* Layered architecture (Controller → Service → Repository)

---

## Features

### Task 1: Build a RESTful API with Spring Boot

✔ Create Product

✔ Retrieve All Products

✔ Retrieve Product by ID

✔ Update Product

✔ Delete Product

✔ DTO Validation

✔ Proper HTTP Status Codes

✔ Layered Architecture

---

### Task 2: Database Integration & Migrations

✔ H2 In-Memory Database

✔ Spring Data JPA Integration

✔ Flyway Database Migrations

✔ Database Schema Versioning

✔ Sample Data Seeding

---

## Tech Stack

| Technology      | Version |
| --------------- | ------- |
| Java            | 21      |
| Spring Boot     | 3.5.x   |
| Spring Data JPA | Latest  |
| Flyway          | Latest  |
| H2 Database     | Latest  |
| Maven           | 3.9+    |

---

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.example.Product_api
│   │       ├── controller
│   │       ├── dto
│   │       ├── model
│   │       ├── repository
│   │       ├── service
│   │       └── ProductApiApplication.java
│   │
│   └── resources
│       ├── db
│       │   └── migration
│       │       ├── V1__Create_product_table.sql
│       │       └── V2__Insert_sample_data.sql
│       │
│       └── application.properties
│
└── test
```

---

## Database Migrations

### V1 - Create Product Table

```sql
CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price DOUBLE NOT NULL
);
```

### V2 - Insert Sample Data

```sql
INSERT INTO product (name, description, price)
VALUES ('Gaming Mouse', 'Wireless RGB mouse', 49.99);

INSERT INTO product (name, description, price)
VALUES ('Mechanical Keyboard', 'Cherry MX Blue switches', 89.50);

INSERT INTO product (name, description, price)
VALUES ('4K Monitor', '32-inch ultra HD display', 349.00);
```

---

# API Endpoints

| Method | Endpoint           | Description       |
| ------ | ------------------ | ----------------- |
| GET    | /api/products      | Get all products  |
| GET    | /api/products/{id} | Get product by ID |
| POST   | /api/products      | Create product    |
| PUT    | /api/products/{id} | Update product    |
| DELETE | /api/products/{id} | Delete product    |

---

# Task 1 Verification (REST API)

## Get All Products

```bash
curl http://localhost:8080/api/products
```

---

## Get Product By ID

```bash
curl http://localhost:8080/api/products/1
```

---

## Create Product

### Git Bash / Linux

```bash
curl -X POST http://localhost:8080/api/products \
-H "Content-Type: application/json" \
-d '{
  "name":"Laptop",
  "description":"Gaming Laptop",
  "price":1200
}'
```

### Windows CMD

```cmd
curl -X POST http://localhost:8080/api/products ^
-H "Content-Type: application/json" ^
-d "{\"name\":\"Laptop\",\"description\":\"Gaming Laptop\",\"price\":1200}"
```

Expected Status:

```text
201 CREATED
```

---

## Update Product

### Git Bash / Linux

```bash
curl -X PUT http://localhost:8080/api/products/1 \
-H "Content-Type: application/json" \
-d '{
  "name":"Updated Mouse",
  "description":"Updated Description",
  "price":59.99
}'
```

### Windows CMD

```cmd
curl -X PUT http://localhost:8080/api/products/1 ^
-H "Content-Type: application/json" ^
-d "{\"name\":\"Updated Mouse\",\"description\":\"Updated Description\",\"price\":59.99}"
```

Expected Status:

```text
200 OK
```

---

## Delete Product

```bash
curl -X DELETE http://localhost:8080/api/products/1
```

Expected Status:

```text
204 NO CONTENT
```

---

## Validation Test

Empty Product Name

```bash
curl -X POST http://localhost:8080/api/products \
-H "Content-Type: application/json" \
-d '{
  "name":"",
  "description":"Invalid Product",
  "price":100
}'
```

Expected Status:

```text
400 BAD REQUEST
```

---

# Task 2 Verification (Database & Flyway)

## Verify Flyway Created Table

Start the application and access:

```text
http://localhost:8080/h2-console
```

Connection Details:

```text
JDBC URL : jdbc:h2:mem:testdb
Username : sa
Password :
```

Use the JDBC URL configured in application.properties.

---

## Verify Sample Data Was Seeded

```bash
curl http://localhost:8080/api/products
```

Expected Response:

```json
[
  {
    "id":1,
    "name":"Gaming Mouse"
  },
  {
    "id":2,
    "name":"Mechanical Keyboard"
  },
  {
    "id":3,
    "name":"4K Monitor"
  }
]
```

---

## Verify Flyway History Table

Inside H2 Console:

Run:

```sql
SELECT * FROM "flyway_schema_history";
```

Expected:

```text
V1__Create_product_table
V2__Insert_sample_data
```

## Verify Product Table Data

Inside H2 Console:

Run:

```sql
SELECT * FROM PRODUCT;
```

Expected Result:

| ID | NAME | DESCRIPTION | PRICE |
|----|------|-------------|--------|
| 1 | Gaming Mouse | Wireless RGB mouse | 49.99 |
| 2 | Mechanical Keyboard | Cherry MX Blue switches | 89.50 |
| 3 | 4K Monitor | 32-inch ultra HD display | 349.00 |
---

## Run Locally

Clone the repository:

```bash
git clone https://github.com/subhojit1707-crypto/Spring-boot-Product-api.git
```

Navigate to the project:

```bash
cd Spring-boot-Product-api
```

Run the application:

```bash
./mvnw spring-boot:run
```

Windows:

```cmd
mvnw.cmd spring-boot:run
```

Application URL:

```text
http://localhost:8080
```

---

## Author

Subhojit Mandal

Backend Development Internship Project
