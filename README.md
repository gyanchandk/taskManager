# Task Manager Backend

A Spring Boot-based backend application for managing users and tasks, featuring **JWT authentication**, role-based access, and RESTful APIs.

---

## 🔹 Features

- **User Management**
  - Sign up
  - Login (JWT authentication)
- **Task Management**
  - Create tasks
  - Retrieve tasks for a user
- **JWT Security**
  - Secure endpoints with token-based authentication
  - Spring Security + OncePerRequestFilter
- **Database**
  - Stores users, tasks, and relationships
  - One-to-Many: User → Task

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot 3+
- Spring Security
- Spring Data JPA (Hibernate)
- PostgreSQL
- JWT (io.jsonwebtoken)
- Lombok


