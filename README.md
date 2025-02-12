Janitri Backend Project


1.Overview

This project is a backend system developed using Spring Boot and MySQL for a company that creates devices to monitor patients' heart rate data. The system manages Users, Patients, and their Heart Rate details. It exposes RESTful APIs for various operations including user registration, patient management, and recording/retrieving heart rate data.

2.Features

    User Registration and Login
        Simple email and password-based registration and login.
        No authentication protocols; email and password matching only.

    Patient Management
        Add new patients.
        Retrieve patient details.

    Heart Rate Data
        Record heart rate data.
        Retrieve heart rate data for specific patients.

3.Technologies Used

    Java 17
    Spring Boot 3.1.3
    MySQL
    JPA (Jakarta Persistence API)
    Maven

4.Setup Instructions
4.1.Prerequisites

    Java 17 installed on your machine.
    MySQL server running and accessible.
    Maven installed for dependency management.

4.2.Database Setup

    4.2.1.Create a database named janitri_db in MySQL:
       CREATE DATABASE janitri_db;

    4.2.2.Update the application.properties file with your MySQL credentials:
        spring.datasource.url=jdbc:mysql://localhost:3306/janitri_db
        spring.datasource.username=YOUR_MYSQL_USERNAME
        spring.datasource.password=YOUR_MYSQL_PASSWORD
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
        server.port=8080

5.Running the Project

    5.1.Clone the repository:
        git clone https://github.com/YOUR_GITHUB_USERNAME/janitri_backend.git
        cd janitri_backend

    5.2.Build the project and download dependencies:
        mvn clean install

    5.3.Run the Spring Boot application:
        mvn spring-boot:run
The server will start on http://localhost:8080.

6.API Documentation

6.1.User Endpoints

6.1.1.Register UserPOST /api/users/register

Request Body:
{
  "email": "user@example.com",
  "password": "password123"
}

Response: 200 OK
{
  "id": 1,
  "email": "user@example.com",
  "password": "password123"
}

6.1.2.Login UserPOST /api/users/login

Request Body:
{
  "email": "user@example.com",
  "password": "password123"
}

Response:

200 OK: "Login successful"

401 Unauthorized: "Invalid credentials"

6.2.Patient Endpoints

6.2.1.Add PatientPOST /api/patients/add

Request Body:
{
  "name": "John Doe",
  "age": 30,
  "gender": "Male"
}

Response: 200 OK
{
  "id": 1,
  "name": "John Doe",
  "age": 30,
  "gender": "Male"
}

6.2.2.Get All PatientsGET /api/patients/

Response: 200 OK
[
  {
    "id": 1,
    "name": "John Doe",
    "age": 30,
    "gender": "Male"
  }
]

6.2.3.Get Patient by IDGET /api/patients/{id}

Response: 200 OK or 404 Not Found

6.3.Heart Rate Endpoints

6.3.1.Record Heart RatePOST /api/heartrate/record

Request Body:
{
  "patient": {
    "id": 1
  },
  "rate": 75
}

Response: 200 OK
{
  "id": 1,
  "patient": {
    "id": 1
  },
  "rate": 75,
  "timestamp": "2024-02-12T15:30:00"
}

6.3.2.Get Heart Rates by Patient IDGET /api/heartrate/patient/{patientId}

Response: 200 OK
[
  {
    "id": 1,
    "rate": 75,
    "timestamp": "2024-02-12T15:30:00"
  }
]



7.Assumptions & Design Decisions

    No authentication protocols like JWT were implemented, as per the assignment requirements.

    Email and password validation is handled via direct matching.

    Relationships were designed with One-to-Many between Patients and Heart Rate records.

    The system assumes that users are trusted, given the lack of advanced authentication.

8.Additional Notes

    Ensure your MySQL server is running on the specified port.

    Modify the application.properties file to match your local database credentials.

    Feel free to extend the project by adding more features or tables if needed.
