# Spring Boot CRUD with PostgreSQL & Swagger API Documentation

This project demonstrates how to create a Spring Boot REST API with CRUD operations (Create, Read, Update, Delete) using PostgreSQL as the database. The application is integrated with **Swagger** to provide detailed and interactive API documentation for easy usage and testing.

## Features

- **Create**: Add new records to the PostgreSQL database.
- **Read**: Retrieve data from the database.
- **Update**: Modify existing records.
- **Delete**: Remove records from the database.
- **Swagger Integration**: Interactive API documentation with Swagger UI.

## Technologies Used

- **Spring Boot**: For building the RESTful API.
- **PostgreSQL**: As the relational database.
- **Swagger (Springdoc OpenAPI)**: For automatic API documentation.
- **JPA/Hibernate**: For ORM and database interaction.
- **Maven**: For project management and dependency handling.

## Prerequisites

Ensure the following are installed:

- **JDK 8 or higher**
- **PostgreSQL** (installed locally or use a cloud-based solution like AWS RDS, Heroku, etc.)
- **Maven** for managing dependencies.

## Setup & Installation

### 1. Clone the repository

```bash
git clone https://github.com/your-username/spring-boot-postgres-crud-swagger.git
cd spring-boot-postgres-crud-swagger
```

### 2. Set up PostgreSQL

- Create a PostgreSQL database:

```
CREATE DATABASE spring_boot_crud;
```

- Update the database credentials in the src/main/resources/application.properties file:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/spring_boot_crud
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build and run the application

Install dependencies and build the project using Maven:

```
mvn clean install
```

#### Run the Spring Boot application:

```
mvn spring-boot:run
```

The application will be available at http://localhost:8080.

## API Endpoints

### Available Endpoints

| ----------- | --------------------------------------- | --------------------------- |
| HTTP Method | Endpoint | Description |
| ----------- | --------------------------------------- | --------------------------- |
| POST | /api/employees/create | Create Employee |
| GET | /api/employees/getAllEmployee | Get all Employee |
| GET | /api/employees/getEmployeeById/{id} | Get Employee By id |
| PATCH | /api/employees/updateEmployee/{id} | Update Employee By id |
| DELETE | /api/employee/deleteEmployee/{id} | Delete Employee By id |

## Swagger UI

To explore and interact with the API endpoints, visit Swagger UI after running the application. Swagger will provide an interactive documentation of all the available endpoints.

## Contributing

Feel free to fork this repository, submit issues, or create pull requests for improvements or new features.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
