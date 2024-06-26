# Spring Boot DDD + Clean Code

This project is a demonstration of building a Spring Boot application using Domain-Driven Design (DDD) principles and adhering to clean code practices.

## Table of Contents

- [Introduction](#introduction)
- [Architecture](#architecture)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This project serves as a template for building a scalable and maintainable Spring Boot application following DDD principles. It emphasizes clean code, separation of concerns, and proper layering of application components.

## Architecture

The project is structured into the following layers:

- **Domain Layer**: Contains the core business logic and domain models.
- **Application Layer**: Contains service interfaces and implementations, DTOs, and application-specific logic.
- **Infrastructure Layer**: Contains data access logic, repositories, and security configurations.
- **Api Layer**: Contains REST controllers and Global Error handlers.
## Technologies Used

- Java 17
- Spring Boot
  - Spring Web
  - Spring Data JPA
  - Spring Security
  - Spring Validation
- H2 Database (for development and testing)
- JWT (JSON Web Tokens) for authentication
- Maven for build automation

## Setup and Installation

### Prerequisites

- Java 17
- Maven
- Git

### Steps

1. **Clone the repository:**
   ```sh
   git clone https://github.com/nadjib1234/Spring-boot-DDD-clean-code.git
   cd Spring-boot-DDD-clean-code
