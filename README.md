# Validation Project

## Overview
  The project implements Custom Validations for the REST API Endpoints Requests and based on the input the Validations done and output is Provided

## Technologies Used
 - JDK 17
 - Maven 3.9.6
 - Spring Boot 3.2.1
 - Jakarta Persistence API (JPA)
 - Jakarta Bean Validation
 - Swagger-ui
 - Lombok
 - Spring Data JPA
 - Spring MVC
 - MYSQL 

## Project Structure
- `C:\Java\Annotation\src\main\java\AnnotationValidation\EmployeClass\Employee.java` : This is the Model Class { POJO Class } for the Employee Class
- `C:\Java\Annotation\src\main\java\AnnotationValidation/RepositoryLayer/DBRepository.java` : Repository Interface Connected to the MYSQL Server
- `C:\Java\Annotation\src\main\java\AnnotationValidation\ServiceLayer\EmployeeService.java` : Service Layer where the Data is Stored into the Data Base {`MYSQL`}
- `C:\Java\Annotation\src\main\java\AnnotationValidation\Annotations` : Custom Annotations are Stored inside this Package
