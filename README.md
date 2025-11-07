# The Need for Speed: Java Microservices Performance Comparison

This repository contains demo projects showcasing performance differences between **Spring Boot** and **Micronaut** frameworks, with a focus on startup time, memory usage, and throughput optimization using various deployment strategies including GraalVM native images, Docker containerization, and advanced JVM features.

## 📊 Presentation

📈 **View the complete presentation**: [The Need for Speed - GraalVM with Micronaut](https://docs.google.com/presentation/d/1uI6Fh9kSpnyXaJLBOXDFTu8AdwJxWsWw2FAGFvw6cLs/edit?usp=sharing)

## 🚀 Projects Overview

This repository contains three main demonstration projects:

### 1. 🌱 Spring Boot Docker Implementation
**Directory**: `spring-docker-image-maven-java/`

Demonstrates Spring Boot application packaging with various optimization strategies including:
- Standard JVM Docker images
- GraalVM native executable Docker images
- AOT (Ahead-of-Time) compilation
- CRaC (Coordinated Restore at Checkpoint) support

**📖 [View Spring Boot Project README](./spring-docker-image-maven-java/README.md)**

### 2. ⚡ Micronaut Docker Implementation  
**Directory**: `micronaut-docker-image-maven-java/`

Showcases Micronaut framework with multiple containerization approaches:
- Jib-based Docker image generation
- Custom Dockerfile with jlink optimization
- GraalVM native image compilation
- CRaC integration for faster startup
- AOT optimizations for improved performance

**📖 [View Micronaut Docker Project README](./micronaut-docker-image-maven-java/README.md)**

### 3. 📊 Micronaut Metrics & Monitoring
**Directory**: `micronaut-metrics-maven-java/`

Advanced Micronaut application demonstrating:
- Prometheus metrics integration
- Custom metrics with Micrometer
- Database operations with H2 and Flyway
- External API integration (Cryptocurrency prices)
- Comprehensive monitoring and observability features

**📖 [View Micronaut Metrics Project README](./micronaut-metrics-maven-java/README.md)**

## 🎯 Performance Benchmarks

Each project includes performance testing scripts (`ttfr.sh` - Time To First Response) that measure:
- **Startup Time**: How quickly the application becomes ready to serve requests
- **Memory Footprint**: RAM consumption across different deployment strategies  
- **Response Time**: API latency and throughput characteristics
- **Image Size**: Docker container size comparisons

## 🛠️ Technologies Demonstrated

- **Frameworks**: Spring Boot 3.3.x vs Micronaut 4.10.1
- **Build Tools**: Maven with specialized plugins
- **Containerization**: Docker with Jib, native Dockerfile, and Spring Boot plugins
- **JVM Optimization**: GraalVM native image compilation
- **Advanced JVM Features**: CRaC (Coordinated Restore at Checkpoint)
- **Monitoring**: Prometheus, Micrometer metrics
- **Database**: H2 with Flyway migrations
- **Code Quality**: Spotless formatting, Maven Enforcer

## 🏃‍♂️ Quick Start

1. **Clone the repository**
2. **Navigate to any project directory**
3. **Follow the specific README instructions** for that project
4. **Run the performance tests** using the provided scripts
5. **Compare results** between Spring Boot and Micronaut implementations

## 📈 Key Learning Outcomes

- Performance characteristics of Spring Boot vs Micronaut
- Impact of GraalVM native image compilation on startup time and memory usage
- Docker optimization strategies for Java microservices
- Monitoring and observability best practices
- Modern JVM features for enterprise applications

---

**🎤 Presented at**: JavaFest - The Need for Speed: GraalVM with Micronaut

**📚 For detailed implementation guidance**, refer to the individual project README files linked above.