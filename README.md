# Quickks Provider Service

A RESTful microservice built with **Spring Boot** for managing Service Providers (Electricians, Plumbers, Mechanics, etc.) on the Quickks platform. This project was developed as part of the Quickks Backend Developer Internship Assessment.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA / Hibernate
- H2 In-Memory Database (or MySQL)
- Spring Validation

## Features

- Add a new service provider
- Retrieve all service providers
- Search service providers by city
- Delete a service provider by ID
- Input validation for mandatory fields (name, phone, city)
- Graceful error handling for invalid/non-existent IDs

## Data Model — Provider

| Field    | Type   | Description                          |
|----------|--------|---------------------------------------|
| id       | Long   | Primary Key, Auto-generated          |
| name     | String | Mandatory                            |
| category | String | e.g., Electrician, Plumber           |
| phone    | String | Mandatory, 10 digits                 |
| city     | String | Mandatory                            |
| rating   | Double | Default: 5.0                         |

## API Endpoints

| Method | Endpoint                        | Description                       |
|--------|----------------------------------|------------------------------------|
| POST   | `/api/v1/providers`             | Add a new service provider        |
| GET    | `/api/v1/providers`             | Retrieve all service providers    |
| GET    | `/api/v1/providers/search?city=` | Search providers by city         |
| DELETE | `/api/v1/providers/{id}`        | Delete a provider by ID           |

## Prerequisites

- Java 17 (or the JDK version used in this project)
- Maven 3.8+
- An IDE (IntelliJ IDEA / VS Code / Eclipse) — optional
- Postman (for testing APIs) — optional

## Project Structure

```
src/main/java/com/quickks/providerservice/
├── controller/     # REST controllers (handles HTTP requests)
├── service/        # Business logic layer
├── repository/     # Spring Data JPA repositories
├── entity/         # Provider entity/model
└── exception/      # Custom exception handling
```

## How to Run the Application

1. **Clone the repository**
   ```bash
   git clone https://github.com/RutujaBorse26/quickks-provider-service.git
   cd quickks-provider-service
   ```

2. **Build the project** (using Maven)
   ```bash
   ./mvnw clean install
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

4. The application will start on:
   ```
   http://localhost:8080
   ```

5. **Database**: The project uses H2 in-memory database by default. The H2 console (if enabled) can be accessed at:
   ```
   http://localhost:8080/h2-console
   ```

## Sample Requests & Responses

### 1. Add a new provider
**Request:** `POST /api/v1/providers`
```json
{
  "name": "ABC Home Services",
  "category": "Cleaning",
  "phone": "9876543210",
  "city": "Pune",
  "rating": 4.5
}
```
**Response:** `201 Created`
```json
{
  "id": 2,
  "name": "ABC Home Services",
  "category": "Cleaning",
  "phone": "9876543210",
  "city": "Pune",
  "rating": 4.5
}
```

### 2. Get all providers
**Request:** `GET /api/v1/providers`
**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "name": "Ramesh Kumar",
    "category": "Electrician",
    "phone": "9876543210",
    "city": "Pune",
    "rating": 4.5
  },
  {
    "id": 2,
    "name": "ABC Home Services",
    "category": "Cleaning",
    "phone": "9876543210",
    "city": "Pune",
    "rating": 4.5
  }
]
```

### 3. Search providers by city
**Request:** `GET /api/v1/providers/search?city=Pune`
**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "name": "Ramesh Kumar",
    "category": "Electrician",
    "phone": "9876543210",
    "city": "Pune",
    "rating": 4.5
  }
]
```

### 4. Delete a provider by ID
**Request:** `DELETE /api/v1/providers/1`
**Response:** `200 OK`
```
Provider deleted successfully
```

## API Testing

Sample API requests and their successful responses are documented via Postman screenshots included in this repository:

- `POST-Providers.png` — Adding a new provider
- `GET-Providers.png` — Fetching all providers
- `GET-City-pune.png` — Searching providers by city (Pune)
- `DELETE-id.png` — Deleting a provider by ID

## Author

Rutuja Borse
