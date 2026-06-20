# Spring Boot Product API

A RESTful Product Management API built with Spring Boot. This project demonstrates CRUD operations, DTO validation, database migrations using Flyway, unit testing with JUnit and Mockito, and application logging with SLF4J.

> **Reviewer Note**
>
> Detailed documentation for each internship task is available in the 
"TaskS" folders within this repository. The folder contains the respective task folder named as Task1, Task2 and Task3, which contains a comprehensive PDF report, screenshots, verification outputs, and supporting files demonstrating the implementation and successful completion of the task requirements.
>
> Please refer to:
>
> - 📂 Tasks

## Features

## Task 1 – REST API Development

Implemented CRUD operations for Product resource.

Features:
- Create Product
- Get All Products
- Get Product By ID
- Update Product
- Delete Product

Technologies:
- Spring Boot
- Spring Data JPA
- Validation
- H2 Database

## Task 2 – Database Integration & Flyway

Implemented:
- H2 Database
- Flyway migrations
- Versioned SQL scripts
- Sample data seeding

Migration Files:
- V1__Create_product_table.sql
- V2__Insert_sample_data.sql

## Task 3 – Unit Testing & Logging

Implemented:
- JUnit 5
- Mockito
- Service layer tests
- SLF4J Logging

Test Coverage:
- createProduct()
- getAllProducts()
- getProductById()
- updateProduct()
- deleteProduct()

---

## Tech Stack

* Java 21
* Spring Boot 3.5
* Spring Data JPA
* H2 Database
* Flyway
* JUnit 5
* Mockito
* Maven

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
│   │       └── service
│   └── resources
│       ├── application.properties
│       └── db
│           └── migration
│               ├── V1__Create_product_table.sql
│               └── V2__Insert_sample_data.sql
└── test
    └── java
        └── com.example.Product_api
            └── service
                └── ProductServiceTest.java
```

---

## Running the Application

### Clone Repository

```bash
git clone https://github.com/subhojit1707-crypto/Spring-boot-Product-api.git
cd Spring-boot-Product-api
```

### Start Application

```bash
mvnw.cmd spring-boot:run
```

Application runs at:

```text
http://localhost:8080
```

---

## H2 Database Console

Enable H2 console:

```properties
spring.h2.console.enabled=true
```

Access:

```text
http://localhost:8080/h2-console
```

JDBC URL:

```text
jdbc:h2:mem:productdb
```

Username:

```text
sa
```

Password:

```text
(empty)
```

---

## Flyway Migration Verification

Check migration history:

```sql
SELECT * FROM FLYWAY_SCHEMA_HISTORY;
```

Check seeded products:

```sql
SELECT * FROM PRODUCT;
```

---

# Task 1 Verification (CRUD API)

## Get All Products

```bash
curl http://localhost:8080/api/products
```

## Get Product By ID

```bash
curl http://localhost:8080/api/products/1
```

## Create Product

```bash
curl -X POST http://localhost:8080/api/products \
-H "Content-Type: application/json" \
-d '{"name":"Laptop","description":"Gaming Laptop","price":20000}'
```

## Update Product

```bash
curl -X PUT http://localhost:8080/api/products/1 \
-H "Content-Type: application/json" \
-d '{"name":"Laptop Pro","description":"Updated Laptop","price":150000}'
```

## Delete Product

```bash
curl -X DELETE http://localhost:8080/api/products/1
```

---

# Task 2 Verification (Flyway & Database)

Verify Flyway migration execution:

```sql
SELECT * FROM FLYWAY_SCHEMA_HISTORY;
```

Verify seeded sample data:

```sql
SELECT * FROM PRODUCT;
```

Expected sample products:

* Gaming Mouse
* Mechanical Keyboard
* 4K Monitor

---

# Task 3 Verification (Testing & Logging)

## Run Unit Tests

```bash
./mvnw test
```

Expected:

```text
BUILD SUCCESS
```

## Test Reports

Generated at:

```text
target/surefire-reports
```

## Logging Verification

Trigger:

```bash
curl http://localhost:8080/api/products
```

Expected log:

```text
INFO ProductService : Fetching all products
```

Update Product:

```bash
curl -X PUT http://localhost:8080/api/products/1 \
-H "Content-Type: application/json" \
-d '{"name":"Android","description":"Android Phone","price":15000}'
```

Expected log:

```text
INFO ProductService : Updating product with ID: 1
INFO ProductService : Product updated successfully: 1
```

---

## Author

Subhojit Mandal