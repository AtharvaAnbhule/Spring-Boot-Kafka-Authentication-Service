# Spring Boot + Kafka Authentication App

A production-ready starter for building JWT-based authentication with Spring Boot, Spring Security, JPA, and Kafka eventing. It includes user sign‑up/sign‑in, access/refresh tokens, role-based authorization, and a Kafka producer that emits user events (e.g., `user_signed_up`, `user_logged_in`).

---

## ✨ Features

* **JWT auth**: Access + Refresh token flow
* **Spring Security 6** with stateless sessions
* **JPA** entities & repositories (PostgreSQL by default, H2 for local/dev)
* **Kafka integration** with a typed producer and custom serializer
* **Role-based authorization** via `@PreAuthorize` and ant matchers
* **Exception handling** for auth and validation errors
* **Docker Compose** for Kafka/ZooKeeper & Postgres
* **Gradle** build with Lombok & annotation processing
* **Test-friendly** profile with H2 & Testcontainers-ready config

---

## 🧱 Architecture

```
app
└── src/main/java/spring/project
    ├── App.java                        # Spring Boot main
    ├── auth
    │   ├── JwtAuthFilter.java          # Extract+validate JWT per request
    │   └── SecurityConfig.java         # HttpSecurity + authentication
    ├── config
    │   └── UserConfig.java             # Beans (PasswordEncoder etc.)
    ├── controller
    │   ├── AuthController.java         # /api/auth/signup, /signin
    │   └── TokenController.java        # /api/auth/refresh
    ├── entities
    │   ├── UserInfo.java               # JPA entity: users
    │   └── RefreshToken.java           # JPA entity: tokens
    ├── eventProducer
    │   └── UserInfoProducer.java       # KafkaTemplate-based producer
    ├── model
    │   └── UserInfoDto.java            # DTO for Kafka/user responses
    ├── repository
    │   ├── UserRepository.java         # CrudRepository<UserInfo, Long>
    │   └── RefreshTokenRepository.java # CrudRepository<RefreshToken, Integer>
    └── services
        ├── JwtService.java             # Issue/validate tokens
        └── UserDetailsServiceImpl.java # LoadUserByUsername, signup helpers
```

> 📌 **Package names must match folder paths.** If your folder is `src/main/java/spring/project/services`, your file must declare `package spring.project.services;`. Do **not** mix with `authservice.*`.

---

## 🧰 Tech Stack

* Java 17+
* Spring Boot 3.3+
* Spring Security, Spring Web, Spring Data JPA
* PostgreSQL (prod) / H2 (dev)
* Apache Kafka + Spring for Apache Kafka
* Lombok
* Gradle 8+

---

## ⚙️ Prerequisites

* JDK 17+
* Gradle wrapper (`./gradlew`)
* Docker (for Kafka/Postgres via compose)

---

## 🚀 Quick Start

### 1) Clone & configure

```bash
git clone https://github.com/AtharvaAnbhule/Spring-Boot-Kafka-Authentication-Service.git
cd spring-boot-kaf
```
