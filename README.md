# SpringBoot CRUD App with Cucumber Integration

This sample project demonstrates the integration of Cucumber with a Spring Boot CRUD application using Spring Data JPA. The application provides RESTful API endpoints for managing student records.

## Table of Contents

- [API Endpoints](#api-endpoints)
- [Integration Testing with Cucumber](#integration-testing-with-cucumber)
- [Getting Started](#getting-started)
  - [Build and Run the Application](#build-and-run-the-application)
  - [Execute Cucumber Tests](#execute-cucumber-tests)
- [Example Usage](#example-usage)

## API Endpoints

1. **GET all Students:** [http://localhost:8080/student](http://localhost:8080/student)
2. **POST save Student:** [http://localhost:8080/student](http://localhost:8080/student)
3. **PUT update an existing student:** [http://localhost:8080/student](http://localhost:8080/student)
4. **DELETE delete an existing student:** [http://localhost:8080/student](http://localhost:8080/student)

Explore the API using the Swagger documentation available at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

![image](https://github.com/arun918kumar/SpringBoot_CRUD_CucumberDemo/assets/57558671/afd1092a-5e76-4a2e-b77a-6fb57c2725f8)


## Integration Testing with Cucumber

The project utilizes the Cucumber framework to develop integration test cases. After executing:

```bash
./gradlew test
```

The Cucumber test report can be accessed at `build/reports/cucumber/cucumber-reports.html`

![image](https://github.com/arun918kumar/SpringBoot_CRUD_CucumberDemo/assets/57558671/dfec02b1-e407-4ae1-b2fd-4c59d0f73f8f)


## Getting Started

### Build and Run the Application

Before running the application, make sure you have Java and Gradle installed.

```bash
# Build and run the app
./gradlew bootRun
```

### Execute Cucumber Tests

To run Cucumber tests and generate a report:

```bash
# Execute cucumber tests and generate a report
./gradlew test
```

## Example Usage

The following commands demonstrate how to build, run the application, and execute Cucumber tests.

```bash
# Build and run the app
./gradlew bootRun

# Execute cucumber tests and generate a report
./gradlew test
```
