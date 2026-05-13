# 🏋️ Fitness Tracking Application

### Secure Spring Boot Backend with JWT Authentication & OTP-Based Password Recovery



<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge\&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-brightgreen?style=for-the-badge\&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge\&logo=mysql)
![JWT](https://img.shields.io/badge/JWT-Authentication-black?style=for-the-badge\&logo=jsonwebtokens)
![Swagger](https://img.shields.io/badge/Swagger-API_Docs-green?style=for-the-badge\&logo=swagger)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge\&logo=apachemaven)

</div>

---

# 📌 Overview

The **Fitness Tracking Application** is a secure backend-based web application developed using **Spring Boot** that allows users to:

* Register and login securely
* Track fitness activities
* Generate personalized recommendations
* Recover passwords using OTP verification
* Access protected APIs using JWT authentication

This project follows modern backend development practices including:

* RESTful API Architecture
* Layered Architecture
* JWT Security
* BCrypt Password Encryption
* DTO-Based Communication
* JPA/Hibernate ORM
* Swagger API Documentation

---

# 🚀 Features

## 🔐 Authentication & Security

* User Registration
* User Login
* JWT Token Authentication
* Secure API Access
* BCrypt Password Encryption
* Stateless Authentication

## 🔑 OTP-Based Password Recovery

* Send OTP
* Verify OTP
* Reset Password
* OTP Expiry Validation
* One-Time Verification

## 🏃 Fitness Activity Management

* Add Daily Activities
* Track Calories Burned
* Track Exercise Duration
* Retrieve Activity History

## 🧠 Recommendation System

* Personalized Fitness Suggestions
* Activity-Based Recommendations
* Recommendation History

## 📄 API Documentation & Testing

* Swagger UI Integration
* Postman API Testing

---

# 🏗️ System Architecture

```text
Client Request
      ↓
Controller Layer
      ↓
Service Layer
      ↓
Repository Layer
      ↓
MySQL Database
```

### Architecture Style

* Monolithic Architecture
* Layered Backend Design
* REST API-Based Communication

---

# 🛠️ Tech Stack

| Technology      | Purpose                        |
| --------------- | ------------------------------ |
| Java            | Programming Language           |
| Spring Boot     | Backend Framework              |
| Spring Security | Authentication & Authorization |
| JWT             | Token-Based Authentication     |
| Hibernate / JPA | ORM Framework                  |
| MySQL           | Database                       |
| Swagger         | API Documentation              |
| Postman         | API Testing                    |
| Maven           | Dependency Management          |
| BCrypt          | Password Encryption            |



---

# 📂 Project Structure

```bash
src/main/java/com/project/fitness
│
├── controller       # REST Controllers
├── service          # Business Logic
├── repository       # Database Operations
├── model            # Entity Classes
├── dto              # Request & Response DTOs
├── security         # JWT & Spring Security
├── config           # Swagger & Configuration
├── exception        # Global Exception Handling
└── utils            # Utility Classes
```

---

# 🔄 Authentication Flow

```text
1. User Registers
2. Password Encrypted using BCrypt
3. User Logs In
4. JWT Token Generated
5. Token Sent in Authorization Header
6. Secure APIs Accessed
```

---

# 🔐 Forgot Password Flow

```text
1. User Enters Registered Email
2. OTP Generated
3. OTP Stored Temporarily
4. User Verifies OTP
5. Password Reset Allowed
```

---

# 📡 REST APIs

## 👤 Authentication APIs

| Method | Endpoint                   | Description    |
| ------ | -------------------------- | -------------- |
| POST   | `/api/auth/register`       | Register User  |
| POST   | `/api/auth/login`          | Login User     |
| POST   | `/api/auth/send-otp`       | Send OTP       |
| POST   | `/api/auth/verify-otp`     | Verify OTP     |
| POST   | `/api/auth/reset-password` | Reset Password |

---

## 🏃 Activity APIs

| Method | Endpoint          | Description    |
| ------ | ----------------- | -------------- |
| POST   | `/api/activities` | Add Activity   |
| GET    | `/api/activities` | Get Activities |

---

## 🧠 Recommendation APIs

| Method | Endpoint                                    | Description              |
| ------ | ------------------------------------------- | ------------------------ |
| POST   | `/api/recommendation/generate`              | Generate Recommendation  |
| GET    | `/api/recommendation/user/{userId}`         | User Recommendations     |
| GET    | `/api/recommendation/activity/{activityId}` | Activity Recommendations |

---

# 🗄️ Database Design

## fitness_user Table

| Field      | Type      |
| ---------- | --------- |
| id         | String    |
| email      | String    |
| password   | String    |
| first_name | String    |
| last_name  | String    |
| role       | String    |
| created_at | Timestamp |
| updated_at | Timestamp |

---

## otp Table

| Field       | Type      |
| ----------- | --------- |
| id          | Long      |
| email       | String    |
| otp         | String    |
| expiry_time | Timestamp |
| verified    | Boolean   |

---

# 🔒 Security Features

* JWT Authentication
* BCrypt Password Encryption
* OTP Verification System
* Secure Protected APIs
* Stateless Session Management
* Token Validation

---

# 📘 Swagger API Documentation

After running the project, access Swagger UI:

```bash
http://localhost:8080/swagger-ui/index.html
```

---

# ▶️ How to Run the Project

## 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/fitness-tracking-app.git
```

## 2️⃣ Open Project

Open in:

* IntelliJ IDEA
* VS Code
* Eclipse

---

## 3️⃣ Configure Database

Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fitness_db
spring.datasource.username=root
spring.datasource.password=your_password
```

---

## 4️⃣ Run Application

```bash
mvn spring-boot:run
```

---

# 🧪 API Testing

### Using Swagger

* Interactive API Testing
* Request/Response Visualization

### Using Postman

* JWT Token Testing
* Header Validation
* API Debugging

---

# 📈 Future Enhancements

* React Frontend Integration
* Email-Based OTP Delivery
* SMS OTP Support
* AI-Based Fitness Recommendations
* Activity Analytics Dashboard
* Mobile Application
* Admin Panel



---

# ✅ Advantages

* Secure Authentication System
* Industry-Standard Security
* Scalable Backend Architecture
* Real-World Project Structure
* Easy Password Recovery
* Maintainable Codebase

---

# ⚠️ Current Limitations

* Frontend Not Fully Implemented
* OTP Currently Console-Based
* Email/SMS Service Not Integrated Yet

---

# 👨‍💻 Author

## Pushkar Prajapati

**B.Tech CSE — 6th Semester**

Backend Developer | Java Developer | Spring Boot Enthusiast

---

# 📚 References

* Spring Boot Documentation
* Spring Security Documentation
* Hibernate Documentation
* JWT Documentation
* Swagger Documentation
* MySQL Documentation

---

# ⭐ Support

If you found this project useful:

* Give this repository a ⭐
* Fork the repository
* Contribute to the project

---

# 📜 License

This project is developed for educational and learning purposes.
