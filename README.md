#**Online Courier Management System**


##**Overview**

The Online Courier Management System is a comprehensive solution for efficiently tracking and managing courier services. It is designed with modularity and scalability in mind, providing distinct modules for various aspects of courier operations.

##**Key Features**
Office Module: Stores and manages information about courier offices.
Shipment Module: Oversees all aspects of shipments.
Manager Module: Centralized data management for system administrators.
Delivery Module: Manages the delivery process.
Payment Module: Handles all payment processes related to courier services.
Customer Module: Controls client information and interactions with the system.

##**Technologies Used**
Spring Boot: Back-end framework for building robust and scalable applications.
MYSQL: Relational database for efficient data storage.
Docker: Containerization for consistent and portable deployments.
JUnit: Testing framework for comprehensive unit testing.
Swagger: API documentation tool for clear and concise communication.

##**Getting Started**
###**Prerequisites**
Java 11 or later

Maven

Docker

###**Installation**
Clone the repository:



git clone https://github.com/KingCanute1011/Online-Courier-Management-System.git

Build the project:



cd online-courier-management
mvn clean install

Run the Docker container:



docker-compose up -d
Access the application at http://localhost:8080

##**API Documentation**
Explore the API endpoints using Swagger documentation available at http://localhost:8080/swagger-ui.html

##**Testing**
Run the unit tests using the following command:



mvn test
